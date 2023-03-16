function listOfNames(array) {
    array.sort((e1, e2) => e1.localeCompare(e2));
    for (let i = 0; i < array.length; i++) {
        console.log(`${i + 1}.${array[i]}`);

    }
}

listOfNames();