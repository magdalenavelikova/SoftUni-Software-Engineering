package christmasPastryShop.entities.cocktails.interfaces;

public class Hibernation extends BaseCocktail {
    private static final double HIBERNATION_PRICE = 4.50;

    public Hibernation(String name, int size, String brand) {
        super(name, size, HIBERNATION_PRICE, brand);
    }
}
