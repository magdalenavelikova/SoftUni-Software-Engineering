package definingClassesExercise.carSalesman;

public class Engine {
    String model;
    int power;
    int displacement;
    String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this(model, power, -1, "n/a");

    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");

    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, -1, efficiency);

    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        if (displacement!=-1) {
            return displacement+"";
        }else {
            return "n/a";
        }
    }

    public String getEfficiency() {
        return efficiency;
    }
}
