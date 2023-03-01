package solidExercise.products.drink;

import solidExercise.products.Product;

public abstract class Drink implements Product {
    private double milliliters;
    private  double caloriesPer100Grams;
    private double density;

    public Drink(double milliliters, double caloriesPer100Grams, double density) {
        this.milliliters = milliliters;
        this.caloriesPer100Grams = caloriesPer100Grams;
        this.density = density;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCalories() {
        double grams = getMilliliters() * density;
        double sum = (caloriesPer100Grams/ 100) * grams;
        return sum;
    }


    public double getLitters() {
        return getMilliliters() / 1000;
    }

    @Override
    public double getKilograms() {
        return getLitters()*density;
    }
}
