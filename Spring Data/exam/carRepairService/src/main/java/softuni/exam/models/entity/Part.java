package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity {

    //    •	part name – accepts char sequence (between 2 to 19 inclusive). The values are unique in the database.
//•	price – a floating point number. Must be between 10 and 2000 (both numbers are INCLUSIVE).
//•	quantity – accepts a positive number.
    @Column(name = "part_name", unique = true, nullable = false)
    private String partName;

    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Integer quantity;

    public Part() {
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
