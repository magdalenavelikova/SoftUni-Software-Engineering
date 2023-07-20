package com.softuni.battleships.models.dtos;

import javax.validation.constraints.Positive;

public class StartBattleDTO {
    @Positive
    private int attackerId;

    @Positive
    private int defenderId;

    public int getAttackerId() {
        return attackerId;
    }

    public void setAttackerId(int attackerId) {
        this.attackerId = attackerId;
    }

    public int getDefenderId() {
        return defenderId;
    }

    public void setDefenderId(int defenderId) {
        this.defenderId = defenderId;
    }
}
