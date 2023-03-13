package football.entities.player;

import static football.common.ExceptionMessages.*;

public  abstract class BasePlayer implements Player {
    private String name;
    private String nationality;
    private double kg;
    private int strength;

    protected BasePlayer(String name, String nationality, double kg, int strength) {
        setName(name);
        setNationality(nationality);
        this.kg = kg;
       setStrength(strength);
    }

@Override
    public void setName(String name) {
        isValid(name, name);
        this.name = name;
    }


    @Override
    public double getKg() {
        return kg;
    }


    public void setNationality(String nationality) {
        isValid(nationality, nationality);
        this.nationality = nationality;
    }


    protected void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException(PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public String getName() {
        return name;
    }
    private static void isValid(String string, String parameter) {
        if (string.equals(null) || string.trim().isEmpty()) {
            String message;
            if(parameter.equals("player")){
                message=PLAYER_NAME_NULL_OR_EMPTY;
            }else {
                message=PLAYER_NATIONALITY_NULL_OR_EMPTY;
            }
            throw new NullPointerException(message);
        }
    }
}
