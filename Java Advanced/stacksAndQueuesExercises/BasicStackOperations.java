package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int counterToPush = Integer.parseInt(input.split("\\s+")[0]);
        int counterToPop = Integer.parseInt(input.split("\\s+")[1]);
        int numberToSearch = Integer.parseInt(input.split("\\s+")[2]);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < counterToPush; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < counterToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(numberToSearch)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));

        }
    }
}
