package bg.softuni.modelmapper.entities.dtos;

import java.math.BigDecimal;

public class BaseEmployeeDTO {
    private String firstName;
    private String lastName;

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
