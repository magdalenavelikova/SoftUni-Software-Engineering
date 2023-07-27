package softuni.exam.models.entity;

import softuni.exam.models.enums.CarType;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {


    @Enumerated(EnumType.STRING)
    @Column(name = "car_type", nullable = false)
    private CarType carType;
    @Column(name = "car_make", nullable = false)
    private String carMake;
    @Column(name = "car_model", nullable = false)
    private String carModel;
    @Positive
    @Column(nullable = false)
    private Integer year;
    @Column(name = "plate_number", nullable = false,unique = true)
    private String plateNumber;
    @Positive
    @Column(nullable = false)
    private Integer kilometers;
    @Column(nullable = false)
    private Double engine;

    public Car() {
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public Double getEngine() {
        return engine;
    }

    public void setEngine(Double engine) {
        this.engine = engine;
    }
}
