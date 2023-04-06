package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private static final double OXYGEN = 70;
    public Biologist(String name) {
        super(name, OXYGEN);
    }

    @Override
    public void breath() {
        if (super.getOxygen() - 5 < 0) {
           super.setOxygen(0);
        } else {
            super.setOxygen(getOxygen() - 5);
        }
    }
}
