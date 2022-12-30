package definingClassesExercise.speedRacing;

public class Car {
    private  int distance;
    private String model;
    private double fuelAmount;
    private double fuelCost;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distance=0;
    }

    public void drive(int amountOfKm) {

        if (amountOfKm * (fuelCost) <= fuelAmount) {
            this.fuelAmount-= amountOfKm * (fuelCost);
            this.distance += amountOfKm;

        } else {
            System.out.println("Insufficient fuel for the drive");
        }

    }

    @Override
    public String toString() {
       return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }
}
