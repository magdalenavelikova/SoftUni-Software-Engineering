package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal{
    private static final double KG = 5.5;
    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, KG, price);
    }

    @Override
    public void eat() {
        super.setKg(super.getKg() + 5.7);
    }
}
