function signCheck(numOne, numTwo, numThree) {
    let counter = 0;
    if (numOne < 0) {
        counter++;
    }
    if (numTwo < 0) {
        counter++;
    }
    if (numThree < 0) {
        counter++;
    }
    if (counter % 2 === 0) {
        return "Positive";
    } else {
        return "Negative";
    }

}

console.log(signCheck(-1, -2, -3));