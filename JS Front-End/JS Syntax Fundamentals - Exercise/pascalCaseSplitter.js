function pascalCaseSplitter(text) {
    let transformedText = '';
    for (const symbol of text) {
        let current = symbol.charCodeAt(0);
        if ((current >= 65 && current <= 90) && (transformedText.length > 0)) {
            transformedText += ", ";
        }
        transformedText += symbol;
    }

    console.log(transformedText);
}

pascalCaseSplitter('SplitMeIfYouCanHaHaYouCantOrYouCan');