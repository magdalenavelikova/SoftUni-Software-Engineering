package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    // private Pet pet;
    private int capacity;
    List<Pet> data = new ArrayList<>();

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    //    •	Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.
    public boolean remove(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (name.equals(data.get(i).getName())) {
                data.remove(i);
                return true;

            }

        }
        return false;
    }

    //    •	Method getPet(String name, String owner)
//    – returns the pet with the given name and owner or null if no such pet exists
    public Pet getPet(String name, String owner) {
        for (int i = 0; i < data.size(); i++) {
            if (name.equals(data.get(i).getName()) && owner.equals(data.get(i).getOwner())) {
                return data.get(i);
            }

        }
        return null;
    }
    //•	Getter getCount – returns the number of pets.
    public int getCount(){
        return data.size();
    }
//    •	getStatistics() – returns a String in the following format:
//o	" The grooming salon has the following clients:
//{name} {owner}
//{name} {owner}
//   (…)"
    public String getStatistics(){
        String returnString=String.format("The grooming salon has the following clients:%n");
        for (Pet pet:data             ) {
            returnString+=String.format("%s %s%n",pet.getName(),pet.getOwner());
        }
        return returnString;

    }
}
