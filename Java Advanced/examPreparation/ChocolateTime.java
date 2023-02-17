package examPreparation;

import java.util.*;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        double[] milk = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Arrays.stream(milk).forEach(milkQueue::offer);

        double[] cacao = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Arrays.stream(cacao).forEach(cacaoStack::push);

        Map<Double, String> neededPercentageByChocolateTypes = new HashMap<>();
        neededPercentageByChocolateTypes.put(30., "Milk Chocolate");
        neededPercentageByChocolateTypes.put(50., "Dark Chocolate");
        neededPercentageByChocolateTypes.put(100., "Baking Chocolate");

        Map<String, Integer> chocolates = new TreeMap<>();
        chocolates.put("Milk Chocolate", 0);
        chocolates.put("Dark Chocolate", 0);
        chocolates.put("Baking Chocolate", 0);

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double milkValue = milkQueue.peek();
            double cacaoPowderValue = cacaoStack.peek();
            double percentage = (cacaoPowderValue / (cacaoPowderValue + milkValue)) * 100;
            cacaoStack.pop();
            if (neededPercentageByChocolateTypes.containsKey(percentage)) {
                String type = neededPercentageByChocolateTypes.get(percentage);
                int value = chocolates.get(type);
                chocolates.put(type, value + 1);
                milkQueue.poll();

            } else {
                milkValue = milkQueue.poll() + 10.;
                milkQueue.offer(milkValue);
            }
        }
        long counter = chocolates.entrySet().stream()
                .filter(e -> e.getValue() == 0)
                .count();

        if (counter > 0) {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        } else {
            System.out.println(String.format("It’s a Chocolate Time. All chocolate types are prepared."));
        }

        if (counter <= 2) {

            chocolates.entrySet().stream()
                    .filter(e -> e.getValue() != 0).forEach(e-> System.out.println("# " + e.getKey() + " --> " + e.getValue()));
        }

    }
}
