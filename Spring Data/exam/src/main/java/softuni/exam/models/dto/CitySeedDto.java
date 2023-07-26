package softuni.exam.models.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//•	city name – a char sequence (between 2 to 60 inclusive). The values are unique in the database. Cannot be null.
//•	description – accepts very long char sequence (min 2 symbols).
//•	population – accepts number values that are more than or equal to 500. Cannot be null.
//•	Constraint: The cities table has а relation with the countries table.

public class CitySeedDto {

    @Size(min = 2, max = 60)
    @NotNull
    @NotEmpty
    private String cityName;

    @Size(min = 2)
    @NotNull
    @NotEmpty
    private String description;

    @Min(value = 500)
    @NotNull
    private Integer population;
    @NotNull
    private Long country;

    public CitySeedDto() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }
}
