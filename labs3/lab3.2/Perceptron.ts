export const Perceptron: (sigma: number, time: number, iterations: number) => string = (sigma, time, iterations) => {
    const Dots = [[0, 6], [1, 5], [3, 3], [2, 4]]
    let W1 = 0
    let W2 = 0
    const result = []
    const start = new Date().getTime()

    let i: number = 0
    while (new Date().getTime() - start < time * 1000 && !!time || i < iterations && !!iterations) {
        let delta = 0
        let index = i % Dots.length
        delta = 4 - (W1 * Dots[index][0] + W2 * Dots[index][1])
        W1 = Math.ceil((W1 + delta * Dots[index][0] * sigma) * 100000) / 100000
        W2 = Math.ceil((W2 + delta * Dots[index][1] * sigma) * 100000) / 100000
        console.log(W1)
        result[index] = delta <= 0 ? '+' : '-'
        i++
    }

    return 'W1 = ' + W1 + ' W2 = ' + W2 + ' A = ' + result[0] + ' B = ' + result[1] + ' C = ' + result[2] + ' D = ' + result[3]
}