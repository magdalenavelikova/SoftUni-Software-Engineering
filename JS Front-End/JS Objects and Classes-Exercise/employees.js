function employees(arr) {
    let employees = [];

    for (let el of arr) {
        employees.push({name:el, personalNumber:el.length});
    }
    for (let employee of employees) {
        console.log(`Name: ${employee.name} -- Personal Number: ${employee.personalNumber}`);

    }

}

employees([
        'Silas Butler',
        'Adnaan Buckley',
        'Juan Peterson',
        'Brendan Villarreal'
    ]
);