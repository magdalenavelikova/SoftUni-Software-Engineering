package conditionalStatementsAdvancedLabAndExcercise;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int videoCards = Integer.parseInt(scanner.nextLine());
        int processors = Integer.parseInt(scanner.nextLine());
        int ram = Integer.parseInt(scanner.nextLine());
        double videoCardsPrice = videoCards * 250.00;
        double processorsPrice = processors * (videoCardsPrice * 0.35);

        double ramPrice = ram * (videoCardsPrice * 0.10);
        double amount = videoCardsPrice + processorsPrice + ramPrice;
        if (videoCards > processors) {
            amount = amount - (amount * 0.15);
        }
        if (budget >= amount) {
            System.out.printf("You have %.2f leva left!", budget - amount);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", amount - budget);
        }


    }
}
