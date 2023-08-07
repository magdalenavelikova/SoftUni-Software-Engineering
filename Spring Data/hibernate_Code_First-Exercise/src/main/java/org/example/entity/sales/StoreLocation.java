package org.example.entity.sales;

import jakarta.persistence.*;
import org.example.entity.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "store_location")

public class StoreLocation extends BaseEntity {
    private String locationName;

    private Set<Sale> sales;

    public StoreLocation() {
        this.sales = new HashSet<>();
    }

    @OneToMany(mappedBy = "storeLocation",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
    @Column(name = "location_name")
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
