package restaurant.entities.healthyFoods;

public class Salad extends Food{
    private static final double INITIAL_PORTION=150;
    public Salad(String name,  double price) {
        super(name, INITIAL_PORTION, price);
    }
}
