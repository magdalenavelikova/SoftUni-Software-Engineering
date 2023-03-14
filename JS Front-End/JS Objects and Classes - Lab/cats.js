function cats(array) {
    class Cat {
        constructor(name, age) {
            this.name = name;
            this.age = age;
        }

        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`);
        }
    }

    for (let el of array) {
        let info = el.split(' ');
        let cat = new Cat(info[0], info[1]);
        cat.meow();
    }

}

cats(['Candy 1', 'Poppy 3', 'Nyx 2']);