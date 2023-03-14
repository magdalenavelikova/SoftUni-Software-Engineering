function addressBook(arr){
    let addressBook={};
    for (let el of arr) {
        let info=el.split(':');
        let name=info[0];
        let street=info[1];
        addressBook[name]=street;
    }
    let sorted = Object.keys(addressBook).sort();
    for (let key of sorted) {
        console.log(`${key} -> ${addressBook[key]}`);
    }
}


addressBook(['Bob:Huxley Rd',
    'John:Milwaukee Crossing',
    'Peter:Fordem Ave',
    'Bob:Redwing Ave',
    'George:Mesta Crossing',
    'Ted:Gateway Way',
    'Bill:Gateway Way',
    'John:Grover Rd',
    'Peter:Huxley Rd',
    'Jeff:Gateway Way',
    'Jeff:Huxley Rd']

);