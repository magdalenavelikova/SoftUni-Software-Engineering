function convertToJSON(name, lastName, hairColor) {
    let obj = {name, lastName, hairColor};
    let output = JSON.stringify(obj);
    console.log(output);
}

convertToJSON('George', 'Jones', 'Brown');