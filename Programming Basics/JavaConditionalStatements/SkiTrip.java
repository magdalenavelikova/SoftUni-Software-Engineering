package JavaConditionalStatements;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String rating = scanner.nextLine();
        double price = 0;
        switch (roomType) {
            case "room for one person":
                price = 18.00;
                break;
            case "apartment":
                price = 25.00;
                break;
            case "president apartment":
                price = 35.00;
                break;
        }
        int overNights = days - 1;
        double amount = price * overNights;
        if (overNights < 10) {
            if ("apartment".equals(roomType)) {
                amount = amount - (amount * .3);
            } else if ("president apartment".equals(roomType)) {
                amount = amount - (amount * .1);

            }
        } else if (overNights < 15) {
            if ("apartment".equals(roomType)) {
                amount = amount - (amount * .35);
            } else if ("president apartment".equals(roomType)) {
                amount = amount - (amount * .15);

            }

        } else {
            if ("apartment".equals(roomType)) {
                amount = amount - (amount * .5);
            } else if ("president apartment".equals(roomType)) {
                amount = amount - (amount * .2);

            }

        }

        if ("positive".equals(rating)) {
            amount = amount * 1.25;
        } else {
            amount = amount - (amount * .1);
        }
        System.out.printf("%.2f", amount);

    }
}
