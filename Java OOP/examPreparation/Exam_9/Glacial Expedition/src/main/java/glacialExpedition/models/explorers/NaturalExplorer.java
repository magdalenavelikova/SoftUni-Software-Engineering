package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private static final double ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        if (getEnergy() - 7 < 0) {
            setEnergy(0);
        } else {
            setEnergy(getEnergy() - 7);
        }
    }
}
