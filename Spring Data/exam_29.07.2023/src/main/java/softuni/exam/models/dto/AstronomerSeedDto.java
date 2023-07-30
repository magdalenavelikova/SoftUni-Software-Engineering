package softuni.exam.models.dto;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "astronomer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerSeedDto {

    //    •	first name - accepts char sequence (between 2 to 30 inclusive).
//•	last name - accepts char sequence (between 2 to 30 inclusive).
//•	salary - accepts number values that are more than or equal to 15000.00.
//•	averageObservationHours - accepts number values that are more than 500.00.
//•	birthday - a date in the "yyyy-MM-dd" format. Can be nullable.
//•	observing star - the current star that the astronomer is studying.
//•	Constraint: The astronomers table has a relation with stars table.
    @Size(min = 2, max = 30)
    @NotEmpty
    @NotNull
    @XmlElement(name = "first_name")
    private String firstName;
    @Size(min = 2, max = 30)
    @NotEmpty
    @NotNull
    @XmlElement(name = "last_name")
    private String lastName;
    @DecimalMin(value = "15000.00")
    private Double salary;
    @DecimalMin(value = "500.00")
    @XmlElement(name = "average_observation_hours")
    private Double averageObservationHours;

    private String birthday;
    @XmlElement(name = "observing_star_id")
    private Long observingStarId;

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Long getObservingStarId() {
        return observingStarId;
    }

    public void setObservingStarId(Long observingStarId) {
        this.observingStarId = observingStarId;
    }
}
