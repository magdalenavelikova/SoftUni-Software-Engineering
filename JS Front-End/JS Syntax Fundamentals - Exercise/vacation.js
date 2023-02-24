function vacation(amount, type, day) {

    let totalPrice = 0;
    switch (day) {
        case 'Friday':
            if (type === 'Students') {
                totalPrice = 8.45 * amount;
                if (amount >= 30) {
                    totalPrice -= totalPrice * .15;
                }
            } else if (type === 'Business') {
                if (amount >= 100) {
                    amount -= 10;
                }
                totalPrice = 10.90 * amount;

            } else if (type === 'Regular') {
                totalPrice = 15 * amount;
                if (amount >= 10 && amount <= 20) {
                    totalPrice -= totalPrice * 0.05;
                }
            }
            break;
        case 'Saturday':
            if (type === 'Students') {
                totalPrice = 9.80 * amount;
                if (amount >= 30) {
                    totalPrice -= totalPrice * 0.15;
                }
            } else if (type === 'Business') {
                if (amount >= 100) {
                    amount -= 10;
                }
                totalPrice = 15.60 * amount;

            } else if (type === 'Regular') {
                totalPrice = 20 * amount;
                if (amount >= 10 && amount <= 20) {
                    totalPrice -= totalPrice * 0.05;
                }
            }
            break;
        case 'Sunday':
            if (type === 'Students') {
                totalPrice = 10.46 * amount;
                if (amount >= 30) {
                    totalPrice -= totalPrice * 0.15;
                }
            } else if (type === 'Business') {
                if (amount >= 100) {
                    amount -= 10;
                }
                totalPrice = 16 * amount;

            } else if (type === 'Regular') {
                totalPrice = 22.50 * amount;
                if (amount >= 10 && amount <= 20) {
                    totalPrice -= totalPrice * 0.05;
                }
            }
            break;
    }
    console.log(`Total price: ${totalPrice.toFixed(2)}`);

}

vacation(30, "Students", "Friday");
vacation(30, "Students", "Saturday");
vacation(30, "Students", "Sunday");