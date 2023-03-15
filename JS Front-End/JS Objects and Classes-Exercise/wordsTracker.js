function wordsTracker(input) {
    let words = input.shift().split(' ');
    let list = [];
    for (let word of words) {
        list[word] = 0;
    }

    input.forEach(w => {
        if (list.hasOwnProperty(w)) {
            list[w]++;
        }
    })

    let sortedArr = Object.keys(list).sort((a,b) => {
        return list[b] - list[a]
    });
    for (let key of sortedArr) {
        console.log(`${key} - ${list[key]}`)
    }

}

wordsTracker([
    'is the',
    'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence']
);