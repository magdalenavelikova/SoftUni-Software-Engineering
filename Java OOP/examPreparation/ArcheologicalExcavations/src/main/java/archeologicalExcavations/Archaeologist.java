package archeologicalExcavations;

public class Archaeologist {
    private String name;
    private double energy;

    public Archaeologist(String name, double energy) {
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return this.name;
    }

    public double getEnergy() {
        return this.energy;
    }
}
