package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;

import static catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House {

    private String name;
    private int capacity;

    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public  BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (capacity == cats.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.stream().forEach(c -> c.eating());
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        String baseInfo =  String.format("%s %s:", this.name, this.getClass().getSimpleName());

        sb.append(baseInfo).append(System.lineSeparator());
        String catsInfo = cats.isEmpty()
                ? "none"
                : cats.stream()
                .map(Cat::getName)
                .collect(Collectors.joining(" "));

        sb.append("Cats: ").append(catsInfo).append(System.lineSeparator());
        sb.append(String.format("Toys: %d Softness: %d", toys.size(), sumSoftness()));

        return sb.toString().trim();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name.equals(null) || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}
