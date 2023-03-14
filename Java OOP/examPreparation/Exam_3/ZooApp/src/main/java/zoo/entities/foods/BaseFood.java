package zoo.entities.foods;

public abstract class BaseFood implements Food {

    private int calories;
    private double price;

    public BaseFood(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
