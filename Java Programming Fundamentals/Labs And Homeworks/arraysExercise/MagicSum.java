package arraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbersArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int magicSum = 0;
        for (int i = 0; i < numbersArray.length - 1; i++) {
            for (int j = i + 1; j < numbersArray.length; j++) {
                magicSum = numbersArray[i] + numbersArray[j];
                if (magicNumber == magicSum) {
                    System.out.println(numbersArray[i] + " " + numbersArray[j]);
                }

            }

        }
    }
}
