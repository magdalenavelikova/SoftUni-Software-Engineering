package moreExamЕxercise;

import java.util.Scanner;

public class AddBags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceForAbove20KiloBag = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());
        int daysBeforeFlight = Integer.parseInt(scanner.nextLine());
        int bagsQuantity = Integer.parseInt(scanner.nextLine());
        double price = 0;
        if (weight < 10) {
            price = priceForAbove20KiloBag * 0.2;
        } else if (weight <= 20) {
            price = priceForAbove20KiloBag * 0.5;
        } else {
            price = priceForAbove20KiloBag;
        }
        if (daysBeforeFlight < 7) {
            price = price * 1.4;
        } else if (daysBeforeFlight <= 30) {
            price = price * 1.15;
        } else {
            price = price * 1.10;
        }
        double amount = bagsQuantity * price;
        System.out.printf("The total price of bags is: %.2f lv.", amount);

    }
}
