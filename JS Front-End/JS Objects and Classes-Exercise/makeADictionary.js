function makeADictionary(input){
    let dictionary= {};
    for (let inputElement of input) {
        let obj=JSON.parse(inputElement);
        let word=Object.keys(obj);
            dictionary[word]=obj;
    }
    let sorted=Object.keys(dictionary).sort((l,r)=> l.localeCompare(r));
    for (let key of sorted) {
        console.log(`Term: ${key} => Definition: ${Object.values(dictionary[key])}`)
    }
    
}
makeADictionary([
        '{"Coffee":"A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."}',
        '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare."}',
        '{"Boiler":"A fuel-burning apparatus or container for heating water."}',
        '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}',
        '{"Microphone":"An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded."}'
    ]
);