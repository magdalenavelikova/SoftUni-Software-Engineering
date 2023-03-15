function movies(input) {

    let list = [];
    for (let line of input) {
        if (line.includes('addMovie')) {
            let nameOfMovie = line.split('addMovie')[1].trim();
            list[nameOfMovie] = {name: nameOfMovie};
        } else if (line.includes('directedBy')) {
            let nameOfMovie = line.split('directedBy')[0].trim();
            let directorOfMovie = line.split('directedBy')[1].trim();

            if (list.hasOwnProperty(nameOfMovie)) {
                list[nameOfMovie].director = directorOfMovie;
            }
        } else if (line.includes('onDate')) {
            let nameOfMovie = line.split('onDate')[0].trim();
            let date = line.split('onDate')[1].trim();
            if (list.hasOwnProperty(nameOfMovie)) {
                list[nameOfMovie].date = date;
            }
        }
    }

    let entries = Object.values(list);
    for (let entry of entries) {
        let counter = Object.keys(entry).length;
        if (counter === 3) {
            console.log(JSON.stringify(entry));
        }

    }


}

movies([
        'addMovie The Avengers',
        'addMovie Superman',
        'The Avengers directedBy Anthony Russo',
        'The Avengers onDate 30.07.2010',
        'Captain America onDate 30.07.2010',
        'Captain America directedBy Joe Russo'
    ]

)