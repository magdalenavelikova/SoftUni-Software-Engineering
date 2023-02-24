function solve(firstNumber, secondNumber, thirdNumber) {
    let maxNumber;
    if (firstNumber > secondNumber && firstNumber > thirdNumber) {
        maxNumber = firstNumber;
    } else if (secondNumber > firstNumber && secondNumber > thirdNumber) {
        maxNumber = secondNumber;
    } else {
        maxNumber = thirdNumber;
    }
    console.log(`The largest number is ${maxNumber}.`);
}
solve(5, -3, 16)