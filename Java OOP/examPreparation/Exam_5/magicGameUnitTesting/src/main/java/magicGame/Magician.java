package magicGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Magician {
    private List<Magic> magics;
    private String username;
    private int health;

    public Magician(String username, int health) {
        this.setUsername(username);
        this.setHealth(health);
        this.magics = new ArrayList<>();
    }

    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().length() < 1) {
            throw new NullPointerException("Cannot be null!");
        }
        this.username = username;
    }

    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException("Health cannot be bellow zero!");
        }
        this.health = health;
    }

    public List<Magic> getMagics() {
        return Collections.unmodifiableList(this.magics);
    }

    public void takeDamage(int damage) {
        if (this.health <= 0) {
            throw new IllegalStateException("Magician is dead!");
        }

        if (this.health - damage < 0) {
            this.health = 0;
        } else {
            this.health -= damage;
        }
    }

    public void addMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException("Magic cannot be null!");
        }

        this.magics.add(magic);
    }

    public boolean removeMagic(Magic magic) {

        return this.magics.remove(magic);
    }

    public Magic getMagic(String name) {
        Magic magic = this.magics.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
        return magic;
    }
}
