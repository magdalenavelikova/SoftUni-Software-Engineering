package While;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sum = 0;
        while (!input.equals("NoMoreMoney")) {
            double amount = Double.parseDouble(input);
            if (amount >= 0) {
                System.out.printf("Increase: %.2f%n", amount);
                sum += amount;

            } else {
                System.out.println("Invalid operation!");
                break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total: %.2f", sum);
    }
}
