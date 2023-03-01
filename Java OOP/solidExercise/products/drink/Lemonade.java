package solidExercise.products.drink;

public class Lemonade extends Drink {

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    private double milliliters;

    public Lemonade(double milliliters) {
        super(milliliters, CALORIES_PER_100_GRAMS, DENSITY);
    }


    public double getMilliliters() {
        return milliliters;
    }


}
