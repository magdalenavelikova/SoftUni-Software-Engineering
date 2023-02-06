package еncapsulationExercise.pizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public double calculateCalories() {
        double calories = 0;
        switch (toppingType) {
            case "Meat":
                calories = 2 * weight * 1.2;
                break;
            case "Veggies":
                calories = 2 * weight * 0.8;
                break;
            case "Cheese":
                calories = 2 * weight * 1.1;
                break;
            case "Sauce":
                calories = 2 * weight * 0.9;
                break;
        }
        return calories;
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }

    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }
}
