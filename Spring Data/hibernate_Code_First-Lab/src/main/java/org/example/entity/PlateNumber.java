package org.example.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
@Entity
@Table(name = "plate_numbers")
public class PlateNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private BigInteger id;
    private String number;
@OneToOne(mappedBy = "plateNumber")
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public PlateNumber() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
