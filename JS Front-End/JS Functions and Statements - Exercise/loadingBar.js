function loadingBar(number) {
    let percent = "%";
    let point = ".";

    if (number === 100) {
        console.log("100% Complete!\n" +
            "[%%%%%%%%%%]")
    } else {
        console.log(`${number}% [${percent.repeat(number / 10)}${point.repeat((100 - number) / 10)}]`);
        console.log("Still loading...");
    }
}

loadingBar(50);
