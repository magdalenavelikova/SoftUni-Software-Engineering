function piccolo(input) {
    let parkingLot = new Set();
    for (let inputElement of input) {
        let info = inputElement.split(', ');
        let direction = info[0];
        let carNumber = info[1];
        if (direction==='IN'){
            parkingLot.add(carNumber);
        }else if(direction==='OUT'){
            parkingLot.delete(carNumber);
        }
    }
    if(parkingLot.size===0){
        console.log( "Parking Lot is Empty");
    }else {
        let sorted=Array.from(parkingLot)
            .sort((l,r)=>l.localeCompare(r))
            .forEach(e=>console.log(e));
    }
}

piccolo(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'IN, CA9999TT',
    'IN, CA2866HI',
    'OUT, CA1234TA',
    'IN, CA2844AA',
    'OUT, CA2866HI',
    'IN, CA9876HH',
    'IN, CA2822UU']
)
piccolo(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'OUT, CA1234TA']
)