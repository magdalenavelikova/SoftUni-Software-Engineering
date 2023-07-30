package softuni.exam.models.dto;

import softuni.exam.models.enums.StarType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class StarSeedDto {
    //    •	name - accepts char sequence (between 2 to 30 inclusive). The values are unique in the database.
//•	light years - The distance from Earth in light years. Accepts only positive number.
//•	description - a long and detailed description about the star with a character
// length value higher than or equal to 6.
//•	star type - categorization of the stars.
// Ordinal enumeration, one of the following – RED_GIANT, WHITE_DWARF, NEUTRON_STAR
//•	observers – a collection with all the astronomers that are studying the star.
//•	Constraint: The stars table has a relation with the constellations table.
//•	Constraint: The stars table has a relation with the astronomers table.
    @Size(min = 2, max = 30)
    @NotEmpty
    @NotNull
    private String name;
    @Positive
    private Double lightYears;
    @NotNull
    private StarType starType;
    @Size(min = 6)
    @NotEmpty
    @NotNull
    private String description;
    @NotNull
    private Long constellation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public StarType getStarType() {
        return starType;
    }

    public void setStarType(StarType starType) {
        this.starType = starType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getConstellation() {
        return constellation;
    }

    public void setConstellation(Long constellation) {
        this.constellation = constellation;
    }
}
