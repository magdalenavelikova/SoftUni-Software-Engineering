package examPreparation.shelter;

public class Main {
    public static void main(String[] args) {
// Initialize the repository
        Shelter shelter = new Shelter(15);

// Initialize entity
        Animal animal = new Animal("Rex", 7, "Sara");

// Print Animal
        System.out.println(animal); // Rex 7 (Sara)

// Add Animal
        shelter.add(animal);

// Remove Animal
        System.out.println(shelter.remove("Rex")); // true
        System.out.println(shelter.remove("Cayra")); // false

        Animal animal1 = new Animal("Bela", 3, "Sia");
        Animal animal2 = new Animal("Stormy", 4, "George");

        shelter.add(animal1);
        shelter.add(animal2);

// Get Oldest Animal
        Animal oldestAnimal = shelter.getOldestAnimal();
        System.out.println(oldestAnimal); // Stormy 4 (George)

// Get Animal
        Animal animal3 = shelter.getAnimal("Bela", "Sia");
        System.out.println(animal3); // Bela 3 (Sia)

// Count
        System.out.println(shelter.getCount()); // 2

// Get Statistics
        System.out.println(shelter.getStatistics());
//The examPreparation.shelter has the following animals:
//Bela Sia
//Stormy George


    }
}