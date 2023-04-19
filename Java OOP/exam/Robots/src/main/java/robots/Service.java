package robots;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Service {
    private String name;
    private int capacity;
    private Collection<Robot> robot;

    public Service(String name, int capacity){
        this.setCapacity(capacity);
        this.setName(name);
        this.robot = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException("Invalid name!");
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid capacity!");
        }
        this.capacity = capacity;
    }

    public int getCount() {
        return this.robot.size();
    }

    public void add(Robot robot){
        if (this.robot.size() == this.capacity){
            throw new IllegalArgumentException("Full service!");
        }
        this.robot.add(robot);
    }

    public void remove(String name) {
        Robot robotToRemove = this.robot.stream()
                .filter(f -> name.equals(f.getName()))
                .findAny()
                .orElse(null);
        if (robotToRemove == null){
            throw new IllegalArgumentException(String.format("Robot with name %s doesn't exist!", name));
        }
        this.robot.remove(robotToRemove);
    }

    public Robot forSale(String name){
        Robot robot = this.robot.stream()
                .filter(f -> name.equals(f.getName()))
                .findAny()
                .orElse(null);
        if (robot == null){
            throw new IllegalArgumentException(String.format("Robot with name %s doesn't exist!", name));
        }
        robot.setReadyForSale(false);

        return robot;
    }

    public String report(){
        String names = this.robot.stream().map(Robot::getName).collect(Collectors.joining(", "));
        return String.format("The robot %s is in the service %s!", names, this.name);
    }

}
