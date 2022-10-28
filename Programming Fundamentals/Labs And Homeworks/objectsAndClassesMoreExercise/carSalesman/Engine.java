package objectsAndClassesMoreExercise.carSalesman;

public class Engine {
    //    An Engine has a model, power, displacement, and efficiency
    private String model;//required
    private int power;//required
    private int displacement;//optional
    private String efficiency;//optional


    public Engine() {

    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}