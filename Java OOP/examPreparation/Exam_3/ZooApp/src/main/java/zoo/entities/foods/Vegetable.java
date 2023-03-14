package zoo.entities.foods;

public class Vegetable extends BaseFood {
    private static final int CALORIES = 50;
    private static final int PRICE = 5;

    public Vegetable() {
        super(CALORIES, PRICE);
    }
}
