package plymorphismExercise.vehiclesExtended;



public class Bus extends VehicleImpl {

    public final static Double AC_ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, AC_ADDITIONAL_CONSUMPTION);
    }
}
