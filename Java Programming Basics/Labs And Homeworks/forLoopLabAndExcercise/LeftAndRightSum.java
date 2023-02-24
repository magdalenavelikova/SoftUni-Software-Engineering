package forLoopLabAndExcercise;

import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int rightSum = 0;
        int leftSum = 0;

        for (int i = 0; i < 2 * n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (i < n) {
                rightSum = rightSum + number;
            } else {
                leftSum = leftSum + number;
            }

        }
        int diff = Math.abs(rightSum - leftSum);
        if (diff == 0) {
            System.out.printf("Yes, sum = %d", rightSum);
        } else {
            System.out.printf("No, diff = %d", diff);
        }

    }
}
