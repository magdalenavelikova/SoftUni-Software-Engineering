package com.softuni.battleships.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Table(name = "ships")
@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    private long health;

    private long power;

    private LocalDate created;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne
    private Category category;

    public Ship() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User owner) {
        this.user = owner;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
