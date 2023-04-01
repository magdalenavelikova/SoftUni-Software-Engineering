package fairyShop.models;

import static fairyShop.common.ExceptionMessages.*;

public class PresentImpl implements Present {
    private String name;
    private int energyRequired;

    public PresentImpl(String name, int energyRequired) {
       setName(name);
        setEnergyRequired(energyRequired);
    }

    protected void setName(String name) {
        if (name.equals(null) || name.trim().isEmpty()) {
            throw new NullPointerException(PRESENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergyRequired(int energyRequired) {
        if (energyRequired < 0) {
            throw new IllegalArgumentException(PRESENT_ENERGY_LESS_THAN_ZERO);
        }
        this.energyRequired = energyRequired;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergyRequired() {
        return this.energyRequired;
    }

    @Override
    public boolean isDone() {
        return this.energyRequired==0;
    }

    @Override
    public void getCrafted() {
        if (this.energyRequired - 10 < 0) {
            this.energyRequired = 0;
        } else {
            this.energyRequired -= 10;
        }
    }
}
