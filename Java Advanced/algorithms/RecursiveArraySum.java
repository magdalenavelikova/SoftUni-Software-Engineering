package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = getSum(arr, 0);
        System.out.println(sum);
    }

    private static int getSum(int[] arr, int i) {
        if (i >= arr.length) {
            return 0;
        }
        return arr[i] + getSum(arr, i + 1);
    }
}
