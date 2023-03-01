package solidExercise.products.drink;

public class Coke extends Drink{

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    public static final double DENSITY = 0.6;

    private double milliliters;

    public Coke(double milliliters) {
        super(milliliters, CALORIES_PER_100_GRAMS, DENSITY);
    }


    public double getMilliliters() {
        return milliliters;
    }


}
