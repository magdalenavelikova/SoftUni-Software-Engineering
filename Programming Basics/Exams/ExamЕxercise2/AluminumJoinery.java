package ExamineЕxercise2;

import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantity = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String delivery = scanner.nextLine();

        if (quantity >= 10) {
            double price = 0;
            double amount = 0;
            switch (type) {
                case "90X130":
                    price = 110.0;
                    amount = (quantity * price);
                    if (quantity > 60) {
                        amount = amount - (amount * 0.08);
                    } else if (quantity > 30) {
                        amount = amount - (amount * 0.05);
                    }
                    break;
                case "100X150":
                    price = 140.0;
                    amount = (quantity * price);

                    if (quantity > 80) {
                        amount = amount - (amount * 0.10);
                    } else if (quantity > 40) {
                        amount = amount - (amount * 0.06);
                    }
                    break;
                case "130X180":
                    price = 190.0;
                    amount = quantity * price;

                    if (quantity > 50) {
                        amount = amount - (amount * 0.12);
                    } else if (quantity > 20) {
                        amount = amount - (amount * 0.07);

                    }
                    break;
                case "200X300":
                    price = 250.0;
                    amount = quantity * price;
                    if (quantity > 50) {
                        amount = amount - (amount * 0.14);
                    } else if (quantity > 25) {
                        amount = amount - (amount * 0.09);
                    }
                    break;
            }
            if (delivery.equals("With delivery")) {
                amount = amount + 60;
            }
            if (quantity > 99) {
                amount = amount - (amount * 0.04);
            }
            System.out.printf("%.2f BGN", amount);

        } else {
            System.out.println("Invalid order");
        }

    }
}
