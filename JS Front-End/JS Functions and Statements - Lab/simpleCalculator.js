function simpleCalculator(firstNumber, secondNumber, operator) {
    switch (operator) {
        case 'multiply':
            return firstNumber * secondNumber;
        case 'divide':
            return firstNumber / secondNumber;
        case 'add':
            return firstNumber + secondNumber;
        case 'subtract':
            return firstNumber - secondNumber;
    }
}

console.log(simpleCalculator(5,
    5,
    'multiply'
));