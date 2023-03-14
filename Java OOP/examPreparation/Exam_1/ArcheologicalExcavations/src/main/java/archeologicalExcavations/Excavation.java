package archeologicalExcavations;

import java.util.ArrayList;
import java.util.Collection;

public class Excavation {
    private static final String INVALID_EXCAVATION_NAME = "Invalid excavation name!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";
    private static final String NO_MORE_EXCAVATION = "No more excavation!";
    private static final String ARCHAEOLOGIST_EXIST = "The archaeologist is already in the excavation!";
    private static final int ZERO_CAPACITY = 0;

    private int capacity;
    private String name;
    private Collection<Archaeologist> archaeologists;

    public Excavation(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.archaeologists = new ArrayList<>();
    }

    public int getCount() {
        return this.archaeologists.size();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void addArchaeologist(Archaeologist archaeologist) {
        if (archaeologists.size() == this.getCapacity()) {
            throw new IllegalArgumentException(NO_MORE_EXCAVATION);
        }
        boolean archaeologistExist = this.archaeologists
                .stream()
                .anyMatch(a -> a.getName().equals(archaeologist.getName()));

        if (archaeologistExist) {
            throw new IllegalArgumentException(String.format(ARCHAEOLOGIST_EXIST, archaeologist.getName()));
        }

        this.archaeologists.add(archaeologist);
    }

    public boolean removeArchaeologist(String archeologistName) {
        Archaeologist archaeologist = this.archaeologists
                .stream()
                .filter(a -> a.getName().equals(archeologistName))
                .findFirst()
                .orElse(null);

        boolean isRemove = this.archaeologists.remove(archaeologist);
        return isRemove;
    }

    private void setCapacity(int capacity) {
        if (capacity < ZERO_CAPACITY) {
            throw new IllegalArgumentException(INVALID_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_EXCAVATION_NAME);
        }
        this.name = name;
    }
}
