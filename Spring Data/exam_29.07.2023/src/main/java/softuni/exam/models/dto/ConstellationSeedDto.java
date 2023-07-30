package softuni.exam.models.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConstellationSeedDto {
    //    //    •	name – accepts char sequence (between 3 to 20 inclusive).
//    The values are unique in the database.
////•	description - accepts char sequence
// about the naming of the constellation with a character length value higher than or equal to 5.
    @Size(min = 3, max = 20)
    @NotEmpty
    @NotNull
    private String name;
    @Size(min = 5)
    @NotEmpty
    @NotNull
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
