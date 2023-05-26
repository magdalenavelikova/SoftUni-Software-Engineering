package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="bikes")
public class Bike extends Vehicle{
}
