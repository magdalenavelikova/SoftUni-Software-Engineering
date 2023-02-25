function revealWords(words, text) {
    let wordArr = words.split(", ");

    for (let word of wordArr) {
        let searchedWord = "*".repeat(word.length);
        text = text.replace(searchedWord, word);
    }
    console.log(text);
}

revealWords('great, learning',
    'softuni is ***** place for ******** new programming languages'
);