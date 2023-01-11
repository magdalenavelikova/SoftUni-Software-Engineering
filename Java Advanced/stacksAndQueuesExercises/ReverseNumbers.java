package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> reversedNumbers = new ArrayDeque<>();

        for (int number : numbers) {
            reversedNumbers.push(number);
        }

        while (!reversedNumbers.isEmpty()) {
            System.out.print(reversedNumbers.pop() + " ");
        }
    }
}
