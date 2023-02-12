package examPreparation;

import java.util.*;

public class PastryShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> neededValueByFood = new HashMap<>();
        neededValueByFood.put(25, "Biscuit");
        neededValueByFood.put(50, "Cake");
        neededValueByFood.put(75, "Pastry");
        neededValueByFood.put(100, "Pie");

        Map<String, Integer> orderedAmountByFood = new LinkedHashMap<>();
        orderedAmountByFood.put("Biscuit", 0);
        orderedAmountByFood.put("Cake", 0);
        orderedAmountByFood.put("Pie", 0);
        orderedAmountByFood.put("Pastry", 0);

        int[] liquids = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] ingredients = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();

        for (int liquid : liquids) {
            liquidsQueue.offer(liquid);
        }

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        for (int ingredient : ingredients) {
            ingredientsStack.push(ingredient);
        }

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int sum = liquidsQueue.peek() + ingredientsStack.peek();
            if (neededValueByFood.containsKey(sum)) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                String food = neededValueByFood.get(sum);
                Integer currentAmount = orderedAmountByFood.get(food);
                orderedAmountByFood.put(food, currentAmount + 1);
            } else {
                liquidsQueue.poll();
                int newValueOfIngredients = ingredientsStack.pop() + 3;
                ingredientsStack.push(newValueOfIngredients);
            }

        }



        long counter = orderedAmountByFood.entrySet().stream()
                .filter(e -> e.getValue() == 0)
                .count();

        if (counter > 0) {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        } else {
            System.out.println("Great! You succeeded in cooking all the food!");
        }


        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            print(liquidsQueue, "Liquids");
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            print(ingredientsStack, "Ingredients");
        }
        orderedAmountByFood.forEach((key, value) -> System.out.println(key + ": " + value));

    }

    private static void print(ArrayDeque<Integer> arrayDeque, String condition) {
        List<String> output = new ArrayList<>();
        if (condition.equals("Ingredients")) {
            System.out.print("Ingredients left: ");
            while (!arrayDeque.isEmpty()) {
                output.add(arrayDeque.pop().toString());
            }
        } else if (condition.equals("Liquids")) {
            System.out.print("Liquids left: ");
            while (!arrayDeque.isEmpty()) {
                output.add(arrayDeque.poll().toString());
            }
        }
        System.out.print(String.join(", ", output));
        System.out.println();
    }


}
