package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut {
    private static final double OXYGEN = 90;

    public Meteorologist(String name) {
        super(name, OXYGEN);
    }
}
