package plymorphismExercise.vehicles;

public class Truck extends VehicleImpl {
    public final static Double AC_ADDITIONAL_CONSUMPTION = 1.6;
    public final static Double LOST_FUEL_AFTER_DRIVER_DEDUCTION = 0.95;

    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AC_ADDITIONAL_CONSUMPTION);
    }


    @Override
    public void refuel(Double litters) {
        super.refuel(litters * LOST_FUEL_AFTER_DRIVER_DEDUCTION);

    }
}
