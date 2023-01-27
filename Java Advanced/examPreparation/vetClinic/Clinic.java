package examPreparation.vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        return data.stream().max(Comparator.comparingInt(Pet::getAge)).orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append("The clinic has the following patients:");

        for (Pet pet : data) {
            output.append(System.lineSeparator());
            output.append(String.format("%s %s", pet.getName(), pet.getOwner()));
        }
        return output.toString();

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
