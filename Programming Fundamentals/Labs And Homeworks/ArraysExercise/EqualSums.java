package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numberArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean isEqual = true;
        for (int i = 0; i < numberArr.length; i++) {
            int rightSum = 0;
            int leftSum = 0;
            int element = numberArr[i];
            if (i > 0) {
                for (int j = i; j > 0; j--) {
                    leftSum += numberArr[j - 1];
                }
            }
            for (int j = i + 1; j < numberArr.length; j++) {
                rightSum += numberArr[j];
            }
            if (rightSum == leftSum) {
                System.out.println(i);
                isEqual = true;
                break;
            } else {
                isEqual = false;
            }

        }
        if (!isEqual) {
            System.out.println("no");
        }
    }
}
