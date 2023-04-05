package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;


import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public abstract class BaseExplorer implements Explorer {
    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.suitcase = new Carton();
    }

    protected void setName(String name) {
        if (name.equals(null) || name.trim().isEmpty()) {
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }

        this.energy = energy;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canSearch() {
        return getEnergy() > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }

    @Override
    public void search() {
        if (getEnergy() - 15 < 0) {
            setEnergy(0);
        } else {
            setEnergy(getEnergy() - 15);
        }
    }

    @Override
    public String toString() {
        StringBuilder output=new StringBuilder();
        String suitcaseReport = suitcase.getExhibits().isEmpty()
                ? "None"
                : suitcase.getExhibits().stream()
                .collect(Collectors.joining(", "));

        output.append( String.format(FINAL_EXPLORER_NAME, name)).append(System.lineSeparator());
        output.append( String.format(FINAL_EXPLORER_ENERGY, energy)).append(System.lineSeparator());
        output.append( String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, suitcaseReport)).append(System.lineSeparator());
        return output.toString().trim();
    }
}
