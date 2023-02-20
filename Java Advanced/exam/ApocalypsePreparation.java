package exam;

import java.util.*;

public class ApocalypsePreparation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> medicamentsStack = new ArrayDeque<>();
        int[] textiles = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.stream(textiles).forEach(textilesQueue::offer);

        int[] medicaments = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.stream(medicaments).forEach(medicamentsStack::push);

        Map<Integer, String> healingItems = new HashMap<>();
        healingItems.put(30, "Patch");
        healingItems.put(40, "Bandage");
        healingItems.put(100, "MedKit");

        Map<String, Integer> collectedHealingItems = new TreeMap<>();


        while (!textilesQueue.isEmpty() && !medicamentsStack.isEmpty()) {
            int sumOfItems = textilesQueue.peek() + medicamentsStack.peek();
            textilesQueue.poll();
            if (healingItems.containsKey(sumOfItems)) {
                String currentItem = healingItems.get(sumOfItems);
                collectedHealingItems.putIfAbsent(currentItem, 0);
                int currentValue = collectedHealingItems.get(currentItem);
                collectedHealingItems.put(currentItem, currentValue + 1);

                medicamentsStack.pop();
            } else if (sumOfItems > 100) {
                int medicamentSupplement = (sumOfItems - 100);
                medicamentsStack.pop();
                medicamentsStack.push(medicamentSupplement + medicamentsStack.pop());
                collectedHealingItems.putIfAbsent("MedKit", 0);
                int currentValue = collectedHealingItems.get("MedKit");
                collectedHealingItems.put("MedKit", currentValue + 1);
            } else {

                medicamentsStack.push(medicamentsStack.pop() + 10);
            }

        }
        if (textilesQueue.isEmpty() && medicamentsStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textilesQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else  {
            System.out.println("Medicaments are empty.");
        }
        if (collectedHealingItems.size() > 0) {
            collectedHealingItems.entrySet().stream()
                    .sorted((left, right) ->
                            right.getValue() - left.getValue())
                    .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
        }

        if (!medicamentsStack.isEmpty()) {
            print(medicamentsStack, "Medicaments");
        }
        if (!textilesQueue.isEmpty()) {
            print(textilesQueue, "Textiles");
        }
    }

    private static void print(ArrayDeque<Integer> arrayDeque, String condition) {
        List<String> output = new ArrayList<>();
        if (condition.equals("Medicaments")) {
            System.out.print("Medicaments left: ");
            while (!arrayDeque.isEmpty()) {
                output.add(arrayDeque.pop().toString());
            }
        } else if (condition.equals("Textiles")) {
            System.out.print("Textiles left: ");
            while (!arrayDeque.isEmpty()) {
                output.add(arrayDeque.poll().toString());
            }
        }
        System.out.print(String.join(", ", output));
        System.out.println();
    }

}
