package football;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class FootballTeam {
    private String name;
    private int vacantPositions;
    private Collection<Footballer> footballers;

    public FootballTeam(String name, int vacantPositions) {
        this.setVacantPositions(vacantPositions);
        this.setName(name);
        this.footballers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Invalid name.");
        }
        this.name = name;
    }

    public int getVacantPositions() {
        return vacantPositions;
    }

    private void setVacantPositions(int vacantPositions) {
        if (vacantPositions < 0) {
            throw new IllegalArgumentException("Invalid vacant position.");
        }
        this.vacantPositions = vacantPositions;
    }

    public int getCount() {
        return this.footballers.size();
    }

    public void addFootballer(Footballer footballer) {
        if (this.footballers.size() == this.vacantPositions) {
            throw new IllegalArgumentException("Football team is full.");
        }
        this.footballers.add(footballer);
    }

    public void removeFootballer(String name) {
        Footballer footballer = this.footballers.stream()
                .filter(f -> name.equals(f.getName()))
                .findAny()
                .orElse(null);
        if (footballer == null) {
            throw new IllegalArgumentException(String.format("A footballer named %s is not on the soccer team.", name));
        }
        this.footballers.remove(footballer);
    }

    public Footballer footballerForSale(String name) {
        Footballer footballer = this.footballers.stream()
                .filter(f -> name.equals(f.getName()))
                .findAny()
                .orElse(null);
        if (footballer == null) {
            throw new IllegalArgumentException(String.format("A footballer named %s is not on the soccer team.", name));
        }
        footballer.setActive(false);

        return footballer;
    }

    public String getStatistics() {
        String names = this.footballers.stream().map(Footballer::getName).collect(Collectors.joining(", "));
        return String.format("The footballer %s is in the team %s.", names, this.name);
    }
}
