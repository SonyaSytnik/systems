export const Ferma : (n : number) => string = (n ) => {
    if (n % 2 === 0) return 'p = 2, q = ' + n/2
    let b, a = Math.ceil(Math.sqrt(n))
    if (a * a === n) return 'p = ' + a + ' q = ' + a
    while (true) {
        let ans = a ** 2 - n;
        b = Math.ceil(Math.sqrt(ans))
        if (b ** 2 === ans) break
        a++
    }
    return 'p = ' + (a - b) + ' q = ' + (a + b)
}