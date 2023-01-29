package algorithms;

import java.util.Scanner;

public class Fibonacci {
    public static long counter = 0;

    public static long[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        dp = new long[n + 1];

        long fibonacci = fibonacci(n);

        System.out.println(fibonacci);

        System.out.println(counter);
    }

    public static long fibonacci(int n) {
        counter++;
        if (n <= 2) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }

}
