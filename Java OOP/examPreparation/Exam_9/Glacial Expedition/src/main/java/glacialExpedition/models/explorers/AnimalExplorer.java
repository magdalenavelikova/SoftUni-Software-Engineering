package glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer{
    private static final double ENERGY = 100;
    public AnimalExplorer(String name) {
        super(name, ENERGY);
    }
}
