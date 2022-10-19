package midExam;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        double amount = 0;
        while (!inputLine.equals("special") && !inputLine.equals("regular")) {
            double price = Double.parseDouble(inputLine);
            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                amount += price;
            }
            inputLine = scanner.nextLine();
        }
        double taxes = amount * 0.2;
        double amountWithTaxes = amount + taxes;
        if (inputLine.equals("special")) {
            amountWithTaxes = amountWithTaxes * 0.9;
        }
        if (amountWithTaxes == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", amount);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n", amountWithTaxes);
        }

    }

}
