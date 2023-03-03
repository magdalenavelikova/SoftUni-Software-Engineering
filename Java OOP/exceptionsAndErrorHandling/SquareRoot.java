package exceptionsAndErrorHandling;

import java.util.Optional;
import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            double square = sqrt(input);
            System.out.printf("%.2f%n", square);
        } catch (IllegalArgumentException ignored) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }

    public static double sqrt(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new IllegalArgumentException("Negative number");
        }
        return Math.sqrt(number);
    }
}
