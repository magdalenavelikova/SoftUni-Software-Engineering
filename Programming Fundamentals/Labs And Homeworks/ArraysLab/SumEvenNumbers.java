package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numberArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;
        for (int i = 0; i < numberArr.length; i++) {
            int currentNumber = numberArr[i];
            if (currentNumber % 2 == 0) {
                sum += currentNumber;
            }
        }
        System.out.println(sum);
    }
}
