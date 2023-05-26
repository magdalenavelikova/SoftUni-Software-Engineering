package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {
    private Integer seats;
    @OneToOne
    private PlateNumber plateNumber;

    public Car() {
    }

    public Car(Long id, String type, String model, BigDecimal price, String fuelType, Integer seats) {
        super(id, type, model, price, fuelType);
        this.seats = seats;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public PlateNumber getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(PlateNumber plateNumber) {
        this.plateNumber = plateNumber;
    }
}
