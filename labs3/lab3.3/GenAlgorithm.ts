const population = 50
const max = 5
const time = 5000
let gens: Array<Array<number>> = []
let deltas: Array<number> = []
let survival: Array<number> = []

const calculateDeltas : (a : number, b: number, c: number, d: number, y: number) => number = (a, b, c,d,y) => {
    for (let i: number = 0; i < population; i++) {
        let result = a * gens[i][0] + b * gens[i][1] + c * gens[i][2] + d * gens[i][3];
        deltas[i] = Math.abs(result - y)
        if (deltas[i] === 0) return i
    }
    return -1
}

const result : (index : number, setGen : any, iterations : number) => string = (index, setGen, iterations) => {
    setGen("generation count : " + iterations)
    return 'x1 = ' + gens[index][0] + ' x2 = ' + gens[index][1] + ' x3 = ' + gens[index][2] + ' x4 = ' + gens[index][3] + ' delta = ' + deltas[index]
}

const parent : (isBad : boolean) => number = (isBad) => {
    let all_chances: Array<number> = []
    for (let i = 0; i < population; i++) all_chances[i] = Math.floor(Math.random() * deltas[i] * 100)
    let parent_index = 0
    if(isBad){
        let live_gen_delta = Infinity
        for (let index = 0; index < population; index++) {
            if (live_gen_delta > all_chances[index]) {
                live_gen_delta = all_chances[index]
                parent_index = index
            }
        }
    }else{
        let live_gen_delta = -Infinity
        for (let index = 0; index < population; index++) {
            if (live_gen_delta < all_chances[index]) {
                live_gen_delta = all_chances[index]
                parent_index = index
            }
        }
    }
    return parent_index
}

export const GenAlgorithm: (a: number, b: number, c: number, d: number, y: number, setGeneration : any, isBad : boolean) => string = (a, b, c, d, y, setGeneration, isBad) => {

    const start: number = new Date().getTime()
    let count = 1;

    for (let i: number = 0; i < population; i++) {
        gens[i] = []
        gens[i][0] = Math.floor(Math.random() * max)
        gens[i][1] = Math.floor(Math.random() * max)
        gens[i][2] = Math.floor(Math.random() * max)
        gens[i][3] = Math.floor(Math.random() * max)
    }

    let indexR = calculateDeltas(a, b, c, d, y)
    if (indexR !== -1) return result(indexR, setGeneration, count)

    let end: number = new Date().getTime()
    while (end - start < time) {
        let overallSurvival = 0
        for (let index = 0; index < population; index++) overallSurvival += 1 / deltas[index]
        for (let index = 0; index < population; index++) survival[index] = (1 / deltas[index]) / overallSurvival

        let father_index = parent(isBad);
        let mother_index = parent(isBad);

        let children_gens: Array<Array<number>> = []
        for (let i = 0; i < population; i++) {
            children_gens[i] = []
            children_gens[i][0] = gens[father_index][0]
            children_gens[i][1] = gens[father_index][1]
            children_gens[i][2] = gens[mother_index][2]
            children_gens[i][3] = gens[mother_index][3]
        }
        count++
        gens = children_gens

        let indexR = calculateDeltas(a, b, c, d, y)
        if (indexR !== -1) return result(indexR, setGeneration, count)
        end = new Date().getTime()
    }

    let smallDelta: number = Infinity
    let deltaIndex: number = 0
    for (let index = 0; index < population; index++) {
        if (deltas[index] < smallDelta) {
            smallDelta = deltas[index]
            deltaIndex = index
        }
    }
    return result(deltaIndex, setGeneration, count)
}