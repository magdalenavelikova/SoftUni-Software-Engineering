function oddAndEvenSum(number) {
    let sumOdd = 0;
    let sumEven = 0;
    let string = number.toString();
    for (let i = 0; i < string.length; i++) {
        if ((Number(string.charAt(i))) % 2 === 0 ) {
            sumEven += Number(string.charAt(i));
        } else {
            sumOdd += Number(string.charAt(i));
        }
    }
    console.log(`Odd sum = ${sumOdd}, Even sum = ${sumEven}`)
}

oddAndEvenSum(1000435);
oddAndEvenSum(3495892137259234);