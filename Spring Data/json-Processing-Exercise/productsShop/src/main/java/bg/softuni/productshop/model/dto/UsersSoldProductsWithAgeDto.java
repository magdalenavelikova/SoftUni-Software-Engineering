package bg.softuni.productshop.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersSoldProductsWithAgeDto {
    @XmlAttribute(name = "first-name")
    @Expose
    private String firstName;
    @XmlAttribute(name = "last-name")
    @Expose
    private String lastName;
    @XmlAttribute
    @Expose
    private int age;
    @XmlElement(name = "sold-products")
    @Expose
    @SerializedName("sold-products")
    private SoldProductsCountDto products;

    public UsersSoldProductsWithAgeDto() {
        products = new SoldProductsCountDto();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SoldProductsCountDto getProducts() {
        return products;
    }

    public void setProducts(SoldProductsCountDto products) {
        this.products = products;
    }
}