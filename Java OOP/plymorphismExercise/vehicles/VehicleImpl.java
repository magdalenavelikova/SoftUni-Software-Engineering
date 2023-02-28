package plymorphismExercise.vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;

    public VehicleImpl(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public void refuel(Double litters) {
        this.setFuelQuantity(this.getFuelQuantity() + litters);
    }
    @Override
    public String drive(Double distance) {
        DecimalFormat decimalFormat=new DecimalFormat("#.##");
        Double neededFuel = distance * getFuelConsumption();
        if (getFuelQuantity() >= neededFuel) {
            setFuelQuantity(getFuelQuantity() - neededFuel);
            return String.format("%s travelled %s km", this.getClass().getSimpleName(),decimalFormat.format(distance));

        } else {
            return this.getClass().getSimpleName()+" needs refueling";
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),fuelQuantity);
    }
}

