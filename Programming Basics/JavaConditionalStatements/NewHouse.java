package JavaConditionalStatements;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flowers = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double price = 0;
        if ("Roses".equals(flowers)) {
            if (quantity > 80) {
                price = 5-(5 * 0.1);
            } else {
                price = 5;
            }

        } else if ("Dahlias".equals(flowers)) {
            if (quantity > 90) {
                price = 3.8-(3.8 * 0.15);
            } else {
                price = 3.8;
            }

        } else if ("Tulips".equals(flowers)) {
            if (quantity > 80) {
                price = 2.8-(2.8 * 0.15);
            } else {
                price = 2.8;
            }

        } else if ("Narcissus".equals(flowers)) {
            if (quantity < 120) {
                price = 3 * 1.15;
            } else {
                price = 3;
            }

        } else if ("Gladiolus".equals(flowers)) {
            if (quantity < 80) {
                price = 2.5 * 1.20;
            } else {
                price = 2.5;
            }

        }
        double amount = quantity * price;
        if (amount <= budget) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", quantity, flowers, budget - amount);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", amount - budget);

        }

    }

}
