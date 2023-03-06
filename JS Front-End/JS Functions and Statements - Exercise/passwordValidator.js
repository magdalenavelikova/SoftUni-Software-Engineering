function passwordValidator(password) {

    let flagForValidPassword = true;
    if (!isValidLength(password)) {
        console.log('Password must be between 6 and 10 characters');
        flagForValidPassword = false;
    }

    if (checkForOtherSymbols(password)) {
        console.log('Password must consist only of letters and digits');
        flagForValidPassword = false;
    }
    if (checkForDigits(password)) {
        console.log('Password must have at least 2 digits');
        flagForValidPassword = false;
    }
    if (flagForValidPassword) {
        console.log('Password is valid');
    }

    function checkForDigits(password) {
        let counter = 0;
        for (const digit of password) {
            if (digit.charCodeAt(0) >= 48 && digit.charCodeAt(0) <= 57) {
                counter++;
            }
        }
        return counter < 2;
    }

    function checkForOtherSymbols(password) {

        for (const symbol of password) {
            if ((symbol.charCodeAt(0) < 48 || symbol.charCodeAt(0) > 57)
                && (symbol.charCodeAt(0) < 97 || symbol.charCodeAt(0) > 122)
                && (symbol.charCodeAt(0) < 65 || symbol.charCodeAt(0) > 90)) {
                return true;
            }
        }

    }

    function isValidLength(password) {
        return password.length >= 6 && password.length <= 10;

    }

}

passwordValidator('logIn');
passwordValidator('MyPass123');
passwordValidator('Pa$s$s');
