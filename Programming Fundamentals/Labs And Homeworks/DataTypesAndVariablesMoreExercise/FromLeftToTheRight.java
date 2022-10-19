package dataTypesAndVariablesMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            long[] numberArray = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            long maxNumber = Long.max(numberArray[0], numberArray[1]);
            maxNumber = Math.abs(maxNumber);
            long lastDigit = maxNumber % 10;
            long sum = 0;

            while (maxNumber > 0) {
                sum += lastDigit;
                maxNumber = maxNumber / 10;
                lastDigit = maxNumber % 10;
            }
            System.out.println(sum);


        }
    }
}
