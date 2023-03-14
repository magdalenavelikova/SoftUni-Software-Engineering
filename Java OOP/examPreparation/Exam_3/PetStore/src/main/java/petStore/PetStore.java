package petStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PetStore {

    private List<Animal> animals;

    public PetStore() {
        this.animals = new ArrayList<>();
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(this.animals);
    }

    public int getCount() {
        return this.animals.size();
    }

    public List<Animal> findAllAnimalsWithMaxKilograms(int kg) {
        List<Animal> animals = this.animals.stream().filter(c -> c.getMaxKilograms() > kg).collect(Collectors.toList());

        return animals;
    }

    public void addAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Animal can't be null");
        }

        this.animals.add(animal);
    }

    public Animal getTheMostExpensiveAnimal() {
        Animal animal = this
                .animals
                .stream()
                .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()))
                .limit(1)
                .findFirst()
                .orElse(null);

        return animal;
    }

    public List<Animal> findAllAnimalBySpecie(String specie) {
        List<Animal> animals = this.animals.stream().filter(c -> c.getSpecie().equals(specie)).collect(Collectors.toList());

        return animals;
    }
}