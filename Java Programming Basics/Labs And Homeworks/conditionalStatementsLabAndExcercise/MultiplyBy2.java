package conditionalStatementsLabAndExcercise;

import java.util.Scanner;

public class MultiplyBy2 {
    public static void main(String[] args) {
        String isNegative="NO";
        Scanner scanner = new Scanner(System.in);
        while ("NO".equals(isNegative)) {
            double number = Double.parseDouble(scanner.nextLine());
            double result = 0;
            if (number >= 0) {
                result = number * 2;
                System.out.printf("Result: %.2f%n", result);
            } else {
                isNegative="YES";
                System.out.println("Negative number!");
            }
        }
    }
}
