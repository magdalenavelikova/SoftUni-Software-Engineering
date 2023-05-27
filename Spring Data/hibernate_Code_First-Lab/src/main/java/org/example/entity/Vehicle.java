package org.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table (name = "vehicles")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)


public abstract class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    private  Long id;
	private String type;
	private String model;
	private BigDecimal price;
	@Column(name = "fuel_type")
	private String fuelType ;

	protected Vehicle(){}
	protected Vehicle(Long id, String type, String model, BigDecimal price, String fuelType) {
		this.id = id;
		this.type = type;
		this.model = model;
		this.price = price;
		this.fuelType = fuelType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
}
