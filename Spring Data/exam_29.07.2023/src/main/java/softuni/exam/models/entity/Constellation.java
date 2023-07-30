package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "constellations")
public class Constellation extends BaseEntity{
//    •	name – accepts char sequence (between 3 to 20 inclusive). The values are unique in the database.
//•	description - accepts char sequence about the naming of the constellation with a character length value higher than or equal to 5.
//•	stars – a collection of all stars that are part the constellation
//•	Constraint: The constellations table has a relation with the stars table.
@Column(unique = true, nullable = false)
private String name;
@Column( nullable = false)
private String description;
@OneToMany(mappedBy = "constellation")
private List<Star> stars;

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

    public List<Star> getStars() {
        return stars;
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
    }
}
