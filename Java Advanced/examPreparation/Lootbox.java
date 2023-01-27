package examPreparation;

import java.util.*;

public class Lootbox {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstLootBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(firstLootBox::offer);
        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(secondLootBox::push);
        List<Integer> claimedItems = new ArrayList<>();

        while (!firstLootBox.isEmpty()) {
            int sum = firstLootBox.peek();
            if (!secondLootBox.isEmpty()) {
                sum += secondLootBox.peek();
                if (sum % 2 == 0) {
                    claimedItems.add(sum);
                    firstLootBox.poll();
                    secondLootBox.pop();
                } else {
                    firstLootBox.offer(secondLootBox.pop());
                }
            } else {
                System.out.println("Second lootbox is empty");
                break;
            }
        }
        if (firstLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }

        int sum = claimedItems.stream().mapToInt(e -> e).sum();

        if (sum >= 100) {
            System.out.println("Your loot was epic! Value: " + sum);
        } else {
            System.out.println("Your loot was poor... Value: " + sum);
        }

    }
}
