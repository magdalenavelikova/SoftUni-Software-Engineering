package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "astronomers")
public class Astronomer extends BaseEntity {
//    •	first name - accepts char sequence (between 2 to 30 inclusive).
//•	last name - accepts char sequence (between 2 to 30 inclusive).
//•	salary - accepts number values that are more than or equal to 15000.00.
//•	averageObservationHours - accepts number values that are more than 500.00.
//•	birthday - a date in the "yyyy-MM-dd" format. Can be nullable.
//•	observing star - the current star that the astronomer is studying.
//•	Constraint: The astronomers table has a relation with stars table.

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Double salary;
    @Column(name = "average_observation_hours", nullable = false)
    private Double averageObservationHours;
    @Column
    private LocalDate birthday;
    @ManyToOne
    private Star observingStar;

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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Star getObservingStar() {
        return observingStar;
    }

    public void setObservingStar(Star observingStar) {
        this.observingStar = observingStar;
    }
}
