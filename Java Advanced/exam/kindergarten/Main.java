package exam.kindergarten;

public class Main {

    public static void main(String[] args) {
        Kindergarten kindergarten = new Kindergarten("Sunshine", 8);

        Child childOne = new Child("Lilyana", "Petrova", 3, "Selena", "0899");
        Child childTwo = new Child("Elona", "Muskova", 4,"Max", "0888");
        Child childThree = new Child("George", "Bush", 5,"Ivan", "0988");
        Child childFour = new Child("Ruzha", "Ignatova", 6,"George", "0789");
        Child childFive = new Child("Veselina", "Kostadinova", 3,"Nikolas", "0788");
        Child childSix = new Child("Tom", "Todorov", 2,"Zendaya", "0799");
        Child childSeven = new Child("Sara", "Gomez", 2,"Victor", "0998");
        Child childEight = new Child("Greta", "Thunberg", 3,"Boris", "0999");
        Child childNine = new Child("Anna", "Cameron", 4, "Breja", "0999");

        System.out.println(kindergarten.addChild(childOne)); // true
        System.out.println(kindergarten.addChild(childTwo)); // true
        System.out.println(kindergarten.addChild(childThree)); // true
        System.out.println(kindergarten.addChild(childFour)); // true
        System.out.println(kindergarten.addChild(childFive)); // true
        System.out.println(kindergarten.addChild(childSix)); // true
        System.out.println(kindergarten.addChild(childSeven)); // true
        System.out.println(kindergarten.addChild(childEight)); // true
        System.out.println(kindergarten.addChild(childNine)); // false

        System.out.println(kindergarten.removeChild("Ruzha")); // true
        System.out.println(kindergarten.removeChild("George")); // true
        System.out.println(kindergarten.removeChild("Elona")); // true
        System.out.println(kindergarten.removeChild("Ruzha")); // false
        System.out.println(kindergarten.removeChild("Tim")); // false

        System.out.println(kindergarten.getChildrenCount()); // 5

        Child getChildTom = kindergarten.getChild("Tom");
        Child getChildGreta = kindergarten.getChild("Greta");

        System.out.println(getChildTom); // Child: Tom Todorov, Age: 2, Contact info: Zendaya - 0799
        System.out.println(getChildGreta); // Child: Greta Thunberg, Age: 3, Contact info: Boris - 0999

        System.out.println(kindergarten.registryReport());
// Registered children in Sunshine:
// --
// Child: Sara Gomez, Age: 2, Contact info: Victor - 0998
// --
// Child: Tom Todorov, Age: 2, Contact info: Zendaya - 0799
// --
// Child: Greta Thunberg, Age: 3, Contact info: Boris - 0999
// --
// Child: Lilyana Petrova, Age: 3, Contact info: Selena - 0899
// --
// Child: Veselina Kostadinova, Age: 3, Contact info: Nikolas - 0788

    }
}
