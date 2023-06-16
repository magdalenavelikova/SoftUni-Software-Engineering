package bg.softuni.productshop.model.dto;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProductsDto {
    @XmlAttribute(name = "first-name")
    @Expose
    private String firstName;
    @XmlAttribute(name = "last-name")
    @Expose
    private String lastName;

    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    @Expose
    private Set<SoldProductsDto> soldProducts;

    public UserWithSoldProductsDto() {
    }

    public UserWithSoldProductsDto(String firstName, String lastName, Integer age, Set<SoldProductsDto> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.soldProducts = soldProducts;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<SoldProductsDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<SoldProductsDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
