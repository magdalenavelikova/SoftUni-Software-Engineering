package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);
        } else if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        } else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
       this.houses.add(house);
        return String.format(String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type));
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        if (type.equals("Ball")) {
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException (INVALID_TOY_TYPE);
        }
        this.toys.buyToy(toy);
        return String.format(String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type));
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        House house = getHouse(houseName);
        house.buyToy(toy);
       this. toys.removeToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException (INVALID_CAT_TYPE);
        }
        House house = getHouse(houseName);
        if ((house.getClass().getSimpleName().equals("ShortHouse") && catType.equals("LonghairCat"))
                || (house.getClass().getSimpleName().equals("LongHouse") && catType.equals("ShorthairCat"))) {
            return UNSUITABLE_HOUSE;
        } else {
            house.addCat(cat);
            return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        }
    }

    @Override
    public String feedingCat(String houseName) {
        House house = getHouse(houseName);
        int size = house.getCats().size();
        house.feeding();
        return String.format(FEEDING_CAT, size);
    }

    private House getHouse(String houseName) {
        return this.houses.stream()
                .filter(h -> h.getName().equals(houseName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String sumOfAll(String houseName) {

        House house = getHouse(houseName);
        double amountOfCats = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double amountOfToys = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double totalSum = amountOfToys + amountOfCats;

        return String.format(VALUE_HOUSE, houseName, totalSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        houses.stream()
                .forEach(h -> sb.append(h.getStatistics()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
