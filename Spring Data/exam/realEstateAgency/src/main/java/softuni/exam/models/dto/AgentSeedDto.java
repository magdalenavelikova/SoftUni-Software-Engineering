package softuni.exam.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AgentSeedDto {
    //    •	first name – accepts char sequences as values where their character
    //    length value higher than or equal to 2. The values are unique in the database.
//•	last name – accepts char sequences as values where their character length value higher than or equal to 2.
//•	email – an email – (must contains ‘@’ and ‘.’ – dot). The email of a seller is unique.
//•	Constraint: The agents table has а relation with the towns table.
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
    @NotEmpty
    @NotNull
    private String town;

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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
