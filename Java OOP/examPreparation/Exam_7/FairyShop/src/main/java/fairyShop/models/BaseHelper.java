package fairyShop.models;

import java.util.ArrayList;
import java.util.Collection;

import static fairyShop.common.ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY;

public abstract class BaseHelper implements Helper {

    private String name;
    private int energy;
    private Collection<Instrument> instruments;


    public BaseHelper(String name, int energy) {
        setName(name);
       setEnergy(energy);
        this.instruments = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name.equals(null) || name.trim().isEmpty()) {
            throw new NullPointerException(HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public void work() {
        if (this.energy - 10 < 0) {
            this.energy = 0;
        } else {
            this.energy -= 10;
        }

    }

    @Override
    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.energy > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    @Override
    public String toString() {
        long count = instruments.stream().filter(i -> i.getPower() > 0).count();
        return String.format("Name: %s%nEnergy: %d%nInstruments: %d not broken left", name, energy, count);

    }
}
