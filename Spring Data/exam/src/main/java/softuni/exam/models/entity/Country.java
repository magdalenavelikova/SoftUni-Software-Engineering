package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name = "countries")
public class Country extends BaseEntity {
    //    •	country name – accepts char sequence (between 2 to 60 inclusive). The values are unique in the database. Cannot be null.
//•	currency – accepts char sequences (between 2 and 20 inclusive). Cannot be null.
    @Column(name = "country_name", unique = true, nullable = false)
    private String countryName;

    @Column(nullable = false, length = 20)
    private String currency;

    public Country() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
