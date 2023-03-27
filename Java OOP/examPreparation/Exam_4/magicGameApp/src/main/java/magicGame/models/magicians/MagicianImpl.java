package magicGame.models.magicians;

import magicGame.models.magics.Magic;

import static magicGame.common.ExceptionMessages.*;


public abstract class MagicianImpl implements Magician {

    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;


    public MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        setAlive();
        setMagic(magic);
    }

    protected void setUsername(String username) {
        if (username.equals(null) || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    protected void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    protected void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    protected void setAlive() {
        if (health > 0) {
            isAlive = true;
        } else {
            isAlive = false;
        }
    }


    protected void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void takeDamage(int points) {
        if (getProtection() > points) {
            setProtection(getProtection() - points);
        } else {
            int rest = points - getProtection();
            if (getHealth() > rest) {
                setHealth(getHealth() - rest);
            }
            setProtection(0);
            setHealth(0);
            setAlive();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName() + ": " + username);
        sb.append(System.lineSeparator());
        sb.append("Health: " + health);
        sb.append(System.lineSeparator());
        sb.append("Protection: " + protection);
        sb.append(System.lineSeparator());
        sb.append("Magic: " + magic.getName());

        return sb.toString();
    }
}

