package football.entities.player;

public class Women extends BasePlayer {
    private static final double KILOGRAMS = 60;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, KILOGRAMS, strength);
    }

    @Override
    public void stimulation() {
        int newStrength = super.getStrength() + 115;
        super.setStrength(newStrength);
    }




}
