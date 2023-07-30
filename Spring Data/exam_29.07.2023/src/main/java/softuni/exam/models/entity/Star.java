package softuni.exam.models.entity;

import softuni.exam.models.enums.StarType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "stars")
public class Star extends BaseEntity {

    //    •	name - accepts char sequence (between 2 to 30 inclusive). The values are unique in the database.
//•	light years - The distance from Earth in light years. Accepts only positive number.
//•	description - a long and detailed description about the star with a character length value higher than or equal to 6.
//•	star type - categorization of the stars. Ordinal enumeration, one of the following – RED_GIANT, WHITE_DWARF, NEUTRON_STAR
//•	observers – a collection with all the astronomers that are studying the star.
//•	Constraint: The stars table has a relation with the constellations table.
//•	Constraint: The stars table has a relation with the astronomers table.
    @Column(unique = true, nullable = false)
    private String name;
    @Column(name = "light_years", nullable = false)
    private Double lightYears;
    @Enumerated(EnumType.STRING)
    @Column(name = "star_type", nullable = false)
    private StarType starType;
    @Column( columnDefinition = "TEXT",nullable = false)
    private String description;
    @ManyToOne
    private Constellation constellation;
    @OneToMany(mappedBy = "observingStar")
    private List<Astronomer> observers;

    public Star() {
    }

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

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }
}
