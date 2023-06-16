package bg.softuni.productshop.model.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Size;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSeedDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    public ProductSeedDto() {
    }
    @Size(min = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
