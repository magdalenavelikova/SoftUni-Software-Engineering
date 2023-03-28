package christmasPastryShop.entities.delicacies.interfaces;

public class Stolen extends BaseDelicacy{
    private static final double INITIAL_STOLEN_PORTION=250;
    public Stolen(String name,  double price) {
        super(name, INITIAL_STOLEN_PORTION, price);
    }
}
