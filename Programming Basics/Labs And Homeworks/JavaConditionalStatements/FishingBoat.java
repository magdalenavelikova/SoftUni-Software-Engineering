package JavaConditionalStatements;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fisherMan = Integer.parseInt(scanner.nextLine());
        double rent = 0;
        double discount = 0.;
        boolean isEven = fisherMan % 2 == 0;
        if (fisherMan <= 6) {
            discount = 0.1;
        } else if (fisherMan <= 11) {
            discount = 0.15;
        } else {
            discount = 0.25;
        }

        if ("Spring".equals(season)) {
            rent = 3000;
        } else if ("Summer".equals(season) || "Autumn".equals(season)) {
            rent = 4200;
        } else if ("Winter".equals(season)) {
            rent = 2600;
        }
        double amount = rent - (rent * discount);
        if (isEven && !season.equals("Autumn")) {
            amount = amount - (amount * 0.05);
        }

        if (budget >= amount) {
            System.out.printf("Yes! You have %.2f leva left.", budget - amount);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", amount - budget);
        }

    }
}
