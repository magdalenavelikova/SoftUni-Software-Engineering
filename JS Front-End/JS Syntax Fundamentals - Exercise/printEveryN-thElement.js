function printEveryNThElement(array, step) {
    let output = [];

    for (let i = 0; i < array.length; i += step) {
        output.push(array[i]);

    }
    return output;

}

printEveryNThElement(['dsa',
        'asd',
        'test',
        'tset'],
    2
);