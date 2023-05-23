package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name="users")


public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(name = "name")
    private String name;
    private String password;

@ManyToOne(cascade = CascadeType.PERSIST)
    private City city;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
