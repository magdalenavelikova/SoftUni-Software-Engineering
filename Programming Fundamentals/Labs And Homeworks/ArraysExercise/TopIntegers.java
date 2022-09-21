package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbersArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isTopInteger = false;
        for (int i = 0; i < numbersArray.length - 1; i++) {
            for (int j = i + 1; j < numbersArray.length; j++) {
                if ((numbersArray[i] > numbersArray[j])) {
                    isTopInteger = true;
                    //break;
                } else {
                    isTopInteger = false;
                    break;
                }

            }
            if (isTopInteger) {
                System.out.print(numbersArray[i] + " ");

            }

        }

        System.out.print(numbersArray[numbersArray.length - 1]);

    }
}
