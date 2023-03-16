function factorialDivision(first, second) {
    let firstFactorial = factorial(first);
    let secondFactorial = factorial(second);
    console.log(`${(firstFactorial / secondFactorial).toFixed(2)}`)

    function factorial(number) {
        if (number < 0) return;
        if (number < 2) return 1;
        return number * factorial(number - 1)
    }
}

console.log(
    factorialDivision(5,
        2
    ));