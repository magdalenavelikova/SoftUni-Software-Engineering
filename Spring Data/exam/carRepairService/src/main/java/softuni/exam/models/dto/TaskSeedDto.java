package softuni.exam.models.dto;

import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TaskSeedDto {
    //•	price – accepts a very big positive number.
//•	date – a date and time of registering the task in the "yyyy-MM-dd HH:mm:ss" format.
//•	Constraint: The task table has a relation with the parts table.
//•	Constraint: The task table has a relation with the mechanics table.
//•	Constraint: The task table has a relation with the cars table.
    @Positive
    private BigDecimal price;

    @NotEmpty
    private String date;
    @NotNull
    private CarIdDto car;
    @NotNull
    private MechanicFirstNameDto mechanic;
    @NotNull
    private PartIdDto part;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CarIdDto getCar() {
        return car;
    }

    public void setCar(CarIdDto car) {
        this.car = car;
    }

    public MechanicFirstNameDto getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicFirstNameDto mechanic) {
        this.mechanic = mechanic;
    }

    public PartIdDto getPart() {
        return part;
    }

    public void setPart(PartIdDto part) {
        this.part = part;
    }
}
