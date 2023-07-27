package softuni.exam.models.dto;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class MechanicSeedDto {
    //•	first name – accepts char sequences as values where their character length value higher than or equal to 2. The values are unique in the database.
//•	last name – accepts char sequences as values where their character length value higher than or equal to 2.
//•	email – an email – (must contains ‘@’ and ‘.’ – dot). The email of a seller is unique.
//•	phone – accepts char sequences as values where their character length value higher than or equal to 2. Can be nullable. The values are unique in the database.

    @Size(min = 2)
    @NotEmpty
    @NotNull
    private String firstName;

    @Size(min = 2)
    @NotEmpty
    @NotNull
    private String lastName;

    @Email
    @NotEmpty
    @NotNull
    private String email;

    @Size(min = 2)
    @NotEmpty
    private String phone;

    public MechanicSeedDto() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
