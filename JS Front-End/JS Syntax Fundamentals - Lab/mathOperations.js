function solve(firstNumber,secondNumber,operator){
    switch (operator){
        case'+':
            console.log(firstNumber+secondNumber);
            break;
        case '-':
            console.log(firstNumber-secondNumber);
            break;
        case '*':
            console.log(firstNumber*secondNumber);
            break;
        case '/':
            console.log(firstNumber/secondNumber);
            break;
        case '%':
            console.log(firstNumber%secondNumber);
            break;
        case '**':
            console.log(firstNumber**secondNumber);
            break;
    }
}
solve(5, 6, '+');
solve(3, 5.5, '*')