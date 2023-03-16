function addAndSubtract(firstInt, secondInt, thirdInt) {
    console.log(subtract(thirdInt));

    function sum(firstInt, secondInt) {
        return firstInt + secondInt;
    }

    function subtract(thirdInt) {
        return sum(firstInt, secondInt) - thirdInt;
    }
}

addAndSubtract(1,
    17,
    30
);