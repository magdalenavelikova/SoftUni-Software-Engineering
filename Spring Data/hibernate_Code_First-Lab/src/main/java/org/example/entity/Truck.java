package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="trucks")
public class Truck extends Vehicle{
    @Column(name = "load_capacity")
    private Double loadCapacity;
}
