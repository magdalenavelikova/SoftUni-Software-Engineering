package org.example.entity.university;

import jakarta.persistence.*;
import org.example.entity.BaseEntity;

@Entity
@Table(name = "people")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Column(name = "first_name", length = 40, nullable = false)

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", length = 50, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone_number", length = 10)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
