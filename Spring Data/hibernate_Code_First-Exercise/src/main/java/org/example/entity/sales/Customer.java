package org.example.entity.sales;

import jakarta.persistence.*;
import org.example.entity.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "customer")
public class Customer extends BaseEntity {
    private String name;
    private  String email;
    private String creditCardNumber;
    private Set<Sale> sales;

    public Customer() {
        this.sales = new HashSet<>();
    }

    @OneToMany(mappedBy = "customer",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false,unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
@Column(name = "credit_card_number")
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
