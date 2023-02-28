package plymorphismExercise.vehicles;

public class Car extends VehicleImpl {
    public final static Double AC_ADDITIONAL_CONSUMPTION = 0.9;

    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AC_ADDITIONAL_CONSUMPTION);
    }

}
