function convertToObject(input) {
    let obj = JSON.parse(input);
    for (const key in obj) {
        console.log(`${key}: ${obj[key]}`)
    }
}

convertToObject('{"name": "George", "age": 40, "town": "Sofia"}');