package bg.softuni.modelmapper.entities.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlTransient
public class BaseEmployeeDTO {
    @Expose
    @XmlAttribute
    private String firstName;
    @Expose
    @XmlAttribute
    private String lastName;
    @Expose
    @SerializedName("city")
    @XmlAttribute(name = "city")
    private String addressCity;

    public BaseEmployeeDTO() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    @Override
    public String toString() {
        return  firstName + " " + lastName ;
    }
}
