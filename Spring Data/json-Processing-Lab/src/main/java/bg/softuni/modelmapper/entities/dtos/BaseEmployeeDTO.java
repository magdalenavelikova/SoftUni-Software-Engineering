package bg.softuni.modelmapper.entities.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class BaseEmployeeDTO {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    @SerializedName("city")
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
