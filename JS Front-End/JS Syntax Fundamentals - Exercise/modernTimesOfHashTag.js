function modernTimesOfHashTag(text) {

    let words = text.split(" ")
        .filter(w => w.startsWith("#") && w.length > 1 && isValid(w));
    for (let word of words) {
        console.log(word.slice(1));
    }
    function isValid(word) {
        let transformedWord = word.toLowerCase().slice(1);
        let isValidWord = true;
        for (const symbol of transformedWord) {
            let current = symbol.charCodeAt(0);
            if (!(current >= 97 && current <= 122)) {
                isValidWord = false;
                break;
            }
        }
        return isValidWord;

    }
}
modernTimesOfHashTag('Nowadays everyone uses # to tag a #special word in #socialMedia');