function reverseAnArrayOfNumbers(n, input) {
    let newArr = input.splice(0, n);
    console.log(newArr.reverse().join(" "));
}

reverseAnArrayOfNumbers(3, [10, 20, 30, 40, 50]);