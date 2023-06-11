package bg.softuni.modelmapper.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {
    private String country;
    private String city;

    public Address() {
    }

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }
    @Column(nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    @Column(nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
