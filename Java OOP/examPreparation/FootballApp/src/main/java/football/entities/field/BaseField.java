package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.*;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    protected BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.equals("null") || name.isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int sumEnergy() {
        return supplements.stream()
                .mapToInt(Supplement::getEnergy)
                .sum();
    }

    public void addPlayer(Player player) {
        if (capacity == players.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        players.add(player);
    }

    public void removePlayer(Player Player) {
        players.remove(players);
    }

    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    public void drag() {
        players.forEach(Player::stimulation);
    }

    public String getInfo() {

        String playersReport = players.isEmpty()
                ? "none"
                : players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(" "));

        return String.format("%s (%s):%n" +
                        "Player: %s%n" +
                        "Supplement: %d%n" +
                        "Energy: %d",
                getName(), getClass().getSimpleName(),
                playersReport,
                supplements.size(),
                sumEnergy());
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public String getName() {
        return name;
    }
}
