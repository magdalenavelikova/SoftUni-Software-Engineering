package plymorphismExercise.vehiclesExtended;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;
    private Double tankCapacity;

    private Double additionalConsumption;

    public VehicleImpl(Double fuelQuantity, Double fuelConsumption, Double tankCapacity, Double additionalConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
        this.additionalConsumption = additionalConsumption;

    }

    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setAdditionalConsumption(Double additionalConsumption) {
        this.additionalConsumption = additionalConsumption;
    }

    public void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
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

    public Double getAdditionalConsumption() {
        return additionalConsumption;
    }

    @Override
    public void refuel(Double litters) {
        Double currentFuel = this.getFuelQuantity();
        if (litters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (currentFuel + litters > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(currentFuel + litters);
    }


    @Override
    public String drive(Double distance) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        Double neededFuel = distance * (getFuelConsumption());
        if (getFuelQuantity() >= neededFuel) {
            setFuelQuantity(getFuelQuantity() - neededFuel);
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));

        } else {
            return this.getClass().getSimpleName() + " needs refueling";
        }
    }

    @Override
    public String driveAC(Double distance) {
        setFuelConsumption(getFuelConsumption() + getAdditionalConsumption());
        String result = drive(distance);
        setFuelConsumption(getFuelConsumption() - getAdditionalConsumption());
        return result;
    }


    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuelQuantity);
    }


}

