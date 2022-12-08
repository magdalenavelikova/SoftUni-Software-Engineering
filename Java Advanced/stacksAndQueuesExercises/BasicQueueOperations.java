package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int counterToOffer = Integer.parseInt(input.split("\\s+")[0]);
        int counterToPoll = Integer.parseInt(input.split("\\s+")[1]);
        int numberToSearch = Integer.parseInt(input.split("\\s+")[2]);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < counterToOffer; i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 0; i < counterToPoll; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(numberToSearch)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));

        }
    }
}
