package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.bag = new Backpack();
    }

    protected void setName(String name) {
        if (name.equals(null) || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public boolean canBreath() {
        return getOxygen() > 0;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public void breath() {
        if (getOxygen() - 10 < 0) {
            setOxygen(0);
        } else {
            setOxygen(getOxygen() - 10);
        }
    }

    @Override
    public String toString() {
        String bagReport = bag.getItems().isEmpty()
                ? "none"
                : bag.getItems().stream()
                .collect(Collectors.joining(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER));
        StringBuilder output = new StringBuilder();

        output.append(String.format(REPORT_ASTRONAUT_NAME, name)).append(System.lineSeparator());
        output.append(String.format(REPORT_ASTRONAUT_OXYGEN, oxygen)).append(System.lineSeparator());
        output.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, bagReport)).append(System.lineSeparator());
        return output.toString().trim();

    }
}
