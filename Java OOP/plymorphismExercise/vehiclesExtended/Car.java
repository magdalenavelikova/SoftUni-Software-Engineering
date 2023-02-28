package plymorphismExercise.vehiclesExtended;

public class Car extends VehicleImpl {
    public final static Double AC_ADDITIONAL_CONSUMPTION = 0.9;

    public Car(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, AC_ADDITIONAL_CONSUMPTION);
    }
}
