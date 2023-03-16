function charactersInRange(symbolOne, symbolTwo) {
    let first = Math.min(symbolOne.charCodeAt(0), symbolTwo.charCodeAt(0));
    let last = Math.max(symbolOne.charCodeAt(0), symbolTwo.charCodeAt(0));
    let output = "";
    for (let i = first + 1; i < last; i++) {
        let currentSymbol = String.fromCharCode(i);
        output += `${currentSymbol} `;
    }
    console.log(output)
}

charactersInRange('#',
    ':'
);