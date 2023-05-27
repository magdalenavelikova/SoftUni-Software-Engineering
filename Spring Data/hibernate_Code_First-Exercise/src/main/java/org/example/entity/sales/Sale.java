package org.example.entity.sales;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.example.entity.BaseEntity;

import java.time.LocalDateTime;

@Entity
public class Sale extends BaseEntity {
    private Product product;
    private Customer customer;
    private StoreLocation storeLocation;
    private LocalDateTime date;

    @ManyToOne(targetEntity = Product.class)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
