package еncapsulationExercise.pizzaCalories;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        String pizzaName = info.split("\\s+")[1];
        int numberOfToppings = Integer.parseInt(info.split("\\s+")[2]);
        Pizza pizza = null;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] doughInfo = scanner.nextLine().split("\\s+");
        String flourType = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        double weightInGrams = Double.parseDouble(doughInfo[3]);
        try {
            Dough dough = new Dough(flourType, bakingTechnique, weightInGrams);
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        String input = scanner.nextLine();
        while (!input.equals("END")) {

            String[] toppingInfo = input.split("\\s+");
            String toppingType = toppingInfo[1];
            double toppingWeightInGrams = Double.parseDouble(toppingInfo[2]);

            try {
                Topping topping = new Topping(toppingType, toppingWeightInGrams);
                pizza.addTopping(topping);
                numberOfToppings--;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            if (numberOfToppings > 0) {
                input = scanner.nextLine();
            } else {
                break;
            }
        }
        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

    }
}
