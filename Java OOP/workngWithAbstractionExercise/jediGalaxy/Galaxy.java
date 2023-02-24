package workngWithAbstractionExercise.jediGalaxy;

public class Galaxy {
    private Field field;
    private Evil evil;
    private Player player;

    public Galaxy(Field field, Evil evil, Player player) {
        this.field = field;
        this.evil = evil;
        this.player = player;
    }

    public void moveEvil() {
        evil.move(this.field);
    }
    public void movePlayer() {
         player.move(field);
    }
}
