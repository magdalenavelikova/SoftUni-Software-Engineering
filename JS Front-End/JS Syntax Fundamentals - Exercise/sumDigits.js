function sumDigits(digit) {
    let sum = 0;
    let arr = Array.from(String(digit));
    for (let i = 0; i < arr.length; i++) {
        sum += Number(arr[i]);
    }

    console.log(sum);
}

sumDigits(245678);