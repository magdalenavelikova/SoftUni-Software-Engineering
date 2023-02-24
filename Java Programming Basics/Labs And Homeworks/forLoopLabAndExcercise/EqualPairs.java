package forLoopLabAndExcercise;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int secondSum = 0;
        int firstSum = 0;
        int countPair = 0;
        int diff = 0;
        int maxDiff = Integer.MIN_VALUE;
        boolean isEqual = true;
        for (int i = 0; i < n; i++) {
            int number1 = Integer.parseInt(scanner.nextLine());
            int number2 = Integer.parseInt(scanner.nextLine());
            countPair += 1;
            if (countPair == 1) {
                firstSum = number1 + number2;
            } else {
                secondSum = number1 + number2;
            }
            if (countPair > 1) {
                if (firstSum == secondSum) {
                    firstSum = secondSum;
                    secondSum = 0;
                } else {
                    isEqual = false;
                    diff = Math.abs(firstSum - secondSum);
                    firstSum = secondSum;
                    secondSum = 0;
                }
                if (diff > maxDiff) {
                    maxDiff = diff;
                }

            }

        }
        if (isEqual) {
            System.out.printf("Yes, value=%d", firstSum);
        } else {
            System.out.printf("No, maxdiff=%d", maxDiff);
        }


    }
}
