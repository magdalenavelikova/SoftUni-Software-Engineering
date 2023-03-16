function leapYear(year) {
    if ((year % 4 === 0 && year % 100 != 0) || year % 400 === 0) {
        console.log('yes');
    } else {
        console.log('no');
    }
}

leapYear(1984);
leapYear(2003);
leapYear(4);