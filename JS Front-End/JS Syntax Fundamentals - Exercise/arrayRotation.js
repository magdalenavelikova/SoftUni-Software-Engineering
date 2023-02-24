function arrayRotation(array, rotation) {
    while (rotation > 0) {
        let current = array.shift();
        array.push(current);
        rotation--;
    }
    console.log(array.join(" "));
}

arrayRotation([51, 47, 32, 61, 21], 2);