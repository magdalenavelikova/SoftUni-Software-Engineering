package computers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerManager {
    private static final String CAN_NOT_BE_NULL_MESSAGE = "Can not be null!";

    private List<Computer> computers;

    public ComputerManager() {
        this.computers = new ArrayList<>();
    }

    public List<Computer> getComputers() {
        return Collections.unmodifiableList(this.computers);
    }

    public int getCount() {
        return this.computers.size();
    }

    public void addComputer(Computer computer) {
        this.validateNullValue(computer, CAN_NOT_BE_NULL_MESSAGE);
        boolean flag = this
                .computers
                .stream()
                .filter(c -> c.getManufacturer().equals(computer.getManufacturer()) && c.getModel().equals(computer.getModel()))
                .findFirst()
                .orElse(null) != null;
        if (flag) {
            throw new IllegalArgumentException("This computer already exists.");
        }

        this.computers.add(computer);
    }

    public Computer removeComputer(String manufacturer, String model) {
        Computer computer = this.getComputer(manufacturer, model);
        this.computers.remove(computer);
        return computer;
    }

    public Computer getComputer(String manufacturer, String model) {
        this.validateNullValue(manufacturer, CAN_NOT_BE_NULL_MESSAGE);
        this.validateNullValue(model, CAN_NOT_BE_NULL_MESSAGE);

        Computer computer = this
                .computers
                .stream()
                .filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
                .findFirst()
                .orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException("There is no computer with this manufacturer and model.");
        }

        return computer;
    }

    public List<Computer> getComputersByManufacturer(String manufacturer) {
        this.validateNullValue(manufacturer, CAN_NOT_BE_NULL_MESSAGE);

        List<Computer> computers = this
                .computers
                .stream()
                .filter(c -> c.getManufacturer().equals(manufacturer))
                .collect(Collectors.toList());

        return computers;
    }

    private void validateNullValue(Object variable, String exceptionMessage) {
        if (variable == null) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}