function evenAndOddSubtraction(array) {
    let oddSum = 0;
    let evenSum = 0;
    array.filter(e => e % 2 === 0).forEach(e => evenSum += e);
    array.filter(e => e % 2 != 0).forEach(e => oddSum += e);
    console.log(evenSum - oddSum);
}

evenAndOddSubtraction([3, 5, 7, 9]);