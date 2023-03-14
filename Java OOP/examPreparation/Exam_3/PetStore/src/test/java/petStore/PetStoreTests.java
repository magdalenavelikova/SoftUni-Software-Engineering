package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;


public class PetStoreTests {
    private PetStore petStore;
    private Animal animal;
    private List<Animal> animals;

    @Before
    public void setup() {
        petStore = new PetStore();
        animals = List.of(
                new Animal("Cat", 15, 20),
                new Animal("Dog", 10, 10),
                new Animal("Fish", 1, 2)
        );
    }

    @Test
    public void testConstructor() {

        Assert.assertEquals(0, petStore.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalShouldThrowWhenAnimalIsNull() {
        petStore.addAnimal(animal);
    }

    @Test
    public void testAddAnimalShouldAddAnimal() {
        animals.stream().forEach(a -> petStore.addAnimal(a));
        Assert.assertEquals(animals.size(), petStore.getCount());

    }

    @Test
    public void testGetAnimalsShouldReturnList() {
        animals.stream().forEach(a -> petStore.addAnimal(a));
        List<Animal> actual = petStore.getAnimals();
        Assert.assertEquals(animals.size(), actual.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetAnimalsShouldThrowExBecauseReturnUnmodifiableList() {
        animals.stream().forEach(a -> petStore.addAnimal(a));
        animal = new Animal("test", 50, 50);
        petStore.getAnimals().add(animal);
    }

    @Test
    public void testFindAllAnimalsWithMaxKilograms() {
        List<Animal> expected = animals.stream().filter(a -> a.getMaxKilograms() > 1).collect(Collectors.toList());
        animals.stream().forEach(a -> petStore.addAnimal(a));
        List<Animal> actual = petStore.findAllAnimalsWithMaxKilograms(1);
        Assert.assertEquals(expected.size(), actual.size());
    }

    @Test
    public void testGetTheMostExpensiveAnimalShouldReturnNull() {
        Animal actual = petStore.getTheMostExpensiveAnimal();
        Assert.assertNull(actual);
    }

    @Test
    public void testGetTheMostExpensiveAnimalShouldReturnAnimal() {
        animals.stream().forEach(a -> petStore.addAnimal(a));
        Animal actual = petStore.getTheMostExpensiveAnimal();
        Assert.assertEquals(20, actual.getPrice(), 0);
    }

    @Test
    public void testGetTheMostExpensiveAnimalShouldReturnFirstAnimal() {
        animals.stream().forEach(a -> petStore.addAnimal(a));
        animal = new Animal("Fish", 10, 20);
        petStore.addAnimal(animal);
        Animal actual = petStore.getTheMostExpensiveAnimal();
        Assert.assertEquals("Cat", actual.getSpecie());
    }

    @Test
    public void testFindAllAnimalBySpecieShouldReturnEmptyList(){
        animals.stream().forEach(a -> petStore.addAnimal(a));
        List<Animal> actual = petStore.findAllAnimalBySpecie("NoSuchSpecie");
        Assert.assertEquals(0,actual.size());

    }
    @Test
    public void testFindAllAnimalBySpecieShouldReturnList(){
        animals.stream().forEach(a -> petStore.addAnimal(a));
        List<Animal> actual = petStore.findAllAnimalBySpecie("Cat");
        Assert.assertEquals(1,actual.size());

    }

}

