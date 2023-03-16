function stringSubstring(word, text) {
    let transformedText = text.toLowerCase().split(" ");

    for (let element of transformedText) {
        if (element === word.toLowerCase()) {
            console.log(word);
            return;
        }

    }
    console.log(`${word} not found!`)
    // if (  transformedText.includes(word.toLowerCase())) {
    //
    // } else {
    //
    // }
}

stringSubstring('javascript',
    'JavaScript is the best programming language'
);
stringSubstring('python',
    'JavaScript is the best programming language'
);