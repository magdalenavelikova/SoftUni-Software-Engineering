function songs(arr) {
    class Song {
        constructor(typeList, name, time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }

    let songs = [];
    let numberOfSongs = Number(arr.shift());
    let typeOfSong = arr.pop();


    for (let i = 0; i < numberOfSongs; i++) {
        let info = arr[i].split('_');
        let typeList = info[0];
        let name = info[1];
        let time = info[2];
        let song = new Song(typeList, name, time);
        songs.push(song);
    }
    if (typeOfSong === 'all') {
        songs.forEach(e => console.log(e.name));
    } else {
        let filtered = songs.filter(s => s.typeList === typeOfSong);
        filtered.forEach(e => console.log(e.name));
    }
}

songs([3,
    'favourite_DownTown_3:14',
    'favourite_Kiss_4:16',
    'favourite_Smooth Criminal_4:01',
    'favourite']
);
songs([4,
    'favourite_DownTown_3:14',
    'listenLater_Andalouse_3:24',
    'favourite_In To The Night_3:58',
    'favourite_Live It Up_3:48',
    'listenLater']
);