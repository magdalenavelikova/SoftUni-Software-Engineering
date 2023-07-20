package com.softuni.battleships.models.dtos;

import com.softuni.battleships.models.Ship;

public class ShipDTO {
    private long id;
    private String name;
    private long health;
    private long power;

    public ShipDTO(Ship ship) {
        this.id = ship.getId();
        this.name = ship.getName();
        this.power = ship.getPower();
        this.health = ship.getHealth();
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getHealth() {
        return health;
    }

    public long getPower() {
        return power;
    }
}
