package softuni.exam.models.dto;

import javax.validation.constraints.*;

public class PartSeedDto {
    //    •	part name – accepts char sequence (between 2 to 19 inclusive). The values are unique in the database.
//•	price – a floating point number. Must be between 10 and 2000 (both numbers are INCLUSIVE).
//•	quantity – accepts a positive number.
    @Size(min = 2, max = 19)
    @NotNull
    @NotEmpty
    private String partName;

    @Min(10)
    @Max(2000)
    @NotNull
       private Double price;
    @Positive
    @NotNull
       private Integer quantity;

    public PartSeedDto() {
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
