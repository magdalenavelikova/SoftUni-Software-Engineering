package football.entities.field;

import football.entities.player.Player;

public class ArtificialTurf extends BaseField {
    private static final int CAPACITY = 150;

    public ArtificialTurf(String name) {
        super(name, CAPACITY);
    }


    @Override
    public void addPlayer(Player player) {
        if (!player.getClass().getSimpleName().equals("Women")) {
            throw new IllegalStateException("The pavement of the terrain is not suitable.");
        }

        super.addPlayer(player);

    }
}
