function palindromeIntegers(array) {
    for (const arrayElement of array) {
        let reverse = String(arrayElement).split('').reverse().join('');
        if (reverse == arrayElement) {
            console.log('true');
        } else {
            console.log('false');
        }
    }
}

palindromeIntegers([32, 2, 232, 1010]);