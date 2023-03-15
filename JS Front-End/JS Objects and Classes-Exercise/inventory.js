function inventory(input) {
    let list = [];
    for (let inputElement of input) {
        let info = inputElement.split(' / ');
        let name = info[0];
        let level = Number(info[1]);
        let items = info[2];
        list[level] = {name, level, items};
    }
    let entries = Object.keys(list).sort((a, b) => a - b);
    for (let entry of entries) {
        let hero = list[entry];
        console.log(`Hero: ${hero.name}`);
        console.log(`level => ${hero.level}`);
        console.log(`items => ${hero.items}`);

    }
}

inventory([
        'Isacc / 25 / Apple, GravityGun',
        'Derek / 12 / BarrelVest, DestructionSword',
        'Hes / 1 / Desolator, Sentinel, Antara'
    ]
)