package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numberArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int counter = 0;
        int equalElements = 0;
        int maxCounter = Integer.MIN_VALUE;
        for (int i = 0; i < numberArray.length - 1; i++) {

            if (numberArray[i] == numberArray[i + 1]) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter > maxCounter) {
                maxCounter = counter;
                equalElements = numberArray[i];
            }

        }
        if (maxCounter > 0) {
            for (int i = 0; i <= maxCounter; i++) {
                System.out.print(equalElements + " ");

            }
        }
    }
}
