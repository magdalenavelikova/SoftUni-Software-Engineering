package basicSyntaxMoreExercise;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double remaining = currentBalance;
        boolean isOutOfMoney = false;
        while (!input.equals("Game Time")) {
            boolean isValidGame = false;

            double price = 0;
            switch (input) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    isValidGame = true;
                    break;
                case "CS: OG":
                    price = 15.99;
                    isValidGame = true;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    isValidGame = true;
                    break;
                case "Honored 2":
                    price = 59.99;
                    isValidGame = true;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    isValidGame = true;
                    break;
            }
            if (isValidGame) {
                remaining -= price;
                if (remaining >= 0) {
                    System.out.println("Bought " + input);
                    isOutOfMoney = false;
                    if (remaining == 0) {
                        isOutOfMoney = true;
                        System.out.println("Out of money!");
                        break;
                    }
                } else {
                    System.out.println("Too Expensive");
                    remaining += price;
                }
            } else {
                System.out.println("Not Found");
            }

            input = scanner.nextLine();
        }

        if (!isOutOfMoney) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", currentBalance - remaining, remaining);
        }
    }
}
