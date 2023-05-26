package org.example.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private BigInteger id;
	private String name;

    @OneToMany(mappedBy = "company")
    private Set <Plane> planes;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(Set<Plane> planes) {
        this.planes = planes;
    }
}
