function oddOccurrences(input) {
    let words = input.split(' ');
    let list = new Map();
    for (let el of words) {
        let word = el.toLowerCase().trim();
        if (list.has(word)) {
            list.set(word, list.get(word) + 1);
        } else {
            list.set(word, 1);
        }

    }
    let filteredArr = Array.from(list).filter(([key, value]) => {
        return Number(value) % 2 != 0;
    });
    let result = '';
    for (let [key, value] of filteredArr) {
        result += key + ' ';
    }
    console.log(result);
}

oddOccurrences('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
oddOccurrences('Cake IS SWEET is Soft CAKE sweet Food');