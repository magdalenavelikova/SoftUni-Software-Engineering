package examPreparation;

import java.util.*;

public class Bombs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasingsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(bombEffectsQueue::offer);

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(bombCasingsStack::push);

        Map<Integer, String> materials = new HashMap<>();
        materials.put(40, "Datura Bombs");
        materials.put(60, "Cherry Bombs");
        materials.put(120, "Smoke Decoy Bombs");

        Map<String, Integer> bombPouch = new TreeMap<>();
        bombPouch.put("Datura Bombs", 0);
        bombPouch.put("Cherry Bombs", 0);
        bombPouch.put("Smoke Decoy Bombs", 0);
        boolean isBombPouchFilled = false;

        while (!bombEffectsQueue.isEmpty() && !bombCasingsStack.isEmpty()&& !isBombPouchFilled) {

            long counter = bombPouch.entrySet().stream()
                    .filter(e -> e.getValue() >= 3)
                    .count();
            if (counter < 3) {
                int currentBombEffect = bombEffectsQueue.peek();
                int currentBombCasing = bombCasingsStack.peek();
                int sum = currentBombEffect + currentBombCasing;
                if (materials.get(sum) != null) {
                    bombEffectsQueue.pop();
                    bombCasingsStack.poll();
                    int value = bombPouch.get(materials.get(sum));
                    bombPouch.put(materials.get(sum), value + 1);
                } else {
                    bombCasingsStack.poll();
                    bombCasingsStack.push(currentBombCasing - 5);
                }
            } else {
                isBombPouchFilled = true;
            }

        }
        if (isBombPouchFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            print(bombEffectsQueue, "Bomb Effects:");
        }
        if (bombCasingsStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            print(bombCasingsStack, "Bomb Casings:");
        }

        bombPouch.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static void print(ArrayDeque<Integer> arrayDeque, String condition) {
        List<String> output = new ArrayList<>();
        if (condition.equals("Bomb Effects:")) {
            System.out.print("Bomb Effects: ");
            while (!arrayDeque.isEmpty()) {
                output.add(arrayDeque.poll().toString());
            }
        } else if (condition.equals("Bomb Casings:")) {
            System.out.print("Bomb Casings: ");
            while (!arrayDeque.isEmpty()) {
                output.add(arrayDeque.pop().toString());
            }
        }
        System.out.print(String.join(", ", output));
        System.out.println();
    }

}
