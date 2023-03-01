package solidExercise.products.food;

import solidExercise.products.Product;

public abstract class Food implements Product {
    private double grams;
    private double caloriesPer100Grams;

    public Food(double grams, double caloriesPer100Grams) {
        this.grams = grams;
        this.caloriesPer100Grams = caloriesPer100Grams;
    }

    public double getGrams() {
        return grams;
    }

    public double getCaloriesPer100Grams() {
        return caloriesPer100Grams;
    }

    @Override
    public double getCalories() {
        return (getCaloriesPer100Grams() / 100) * getGrams();

    }
@Override
    public double getKilograms() {
        return getGrams() / 1000;
    }
}
