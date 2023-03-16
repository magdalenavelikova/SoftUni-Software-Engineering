function sortingNumbers(numbers) {
    let sorted = [...numbers].sort((a, b) => {
        let result = a - b;
        return result;
    });
    let newArray = [];
    let counter = sorted.length;
    for (let i = 0; i < counter; i++) {
        if (i % 2 === 0) {
            newArray.push(sorted.shift());
        } else {
            newArray.push(sorted.pop());
        }
    }
    return newArray;

}

sortingNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);