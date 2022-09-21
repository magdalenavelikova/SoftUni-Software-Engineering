package BasicSyntaxExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleQuantity = Integer.parseInt(scanner.nextLine());
        String groupName = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        double sum = 0;
        switch (groupName) {
            case "Students":
                if (day.equals("Friday")) {
                    price = 8.45;
                } else if (day.equals("Saturday")) {
                    price = 9.80;
                } else if (day.equals("Sunday")) {
                    price = 10.46;
                }
                sum = peopleQuantity * price;
                if (peopleQuantity >= 30) {
                    sum = sum - sum * 0.15;
                }
                break;
            case "Business":
                if (day.equals("Friday")) {
                    price = 10.90;
                } else if (day.equals("Saturday")) {
                    price = 15.60;
                } else if (day.equals("Sunday")) {
                    price = 16.0;
                }
                sum = peopleQuantity * price;
                if (peopleQuantity >= 100) {
                    sum = sum - (10 * price);
                }
                break;
            case "Regular":
                if (day.equals("Friday")) {
                    price = 15.0;
                } else if (day.equals("Saturday")) {
                    price = 20.0;
                } else if (day.equals("Sunday")) {
                    price = 22.50;
                }
                sum = peopleQuantity * price;
                if (peopleQuantity >= 10 && peopleQuantity <= 20) {
                    sum = sum - sum * 0.05;
                }
                break;

        }
        System.out.printf("Total price: %.2f", sum);

    }
}
