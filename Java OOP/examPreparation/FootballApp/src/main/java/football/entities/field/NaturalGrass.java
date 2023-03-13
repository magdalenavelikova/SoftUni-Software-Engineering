package football.entities.field;

import football.entities.player.Player;

public class NaturalGrass extends BaseField {
    private static final int CAPACITY = 250;

    public NaturalGrass(String name) {
        super(name, CAPACITY);
    }



    @Override
    public void addPlayer(Player player) {
        if (!player.getClass().getSimpleName().equals("Men")) {
            throw new IllegalStateException("The pavement of the terrain is not suitable.");
        }
        super.addPlayer(player);
    }
}
