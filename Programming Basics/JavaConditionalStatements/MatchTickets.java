package JavaConditionalStatements;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        ⦁	На първия ред е бюджетът – реално число в интервала [1 000.00 ... 1 000 000.00]
//⦁	На втория ред е категорията – "VIP" или "Normal"
//⦁	На третия ред е броят на хората в групата – цяло число в интервала [1 ... 200]
        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int countPeople = Integer.parseInt(scanner.nextLine());
        double price = 0;
        switch (category) {
            case "VIP":
                price = 499.99;
                break;
            case "Normal":
                price = 249.99;
                break;
        }
        double transportPrice = 0;
//От 1 до 4 – 75% от бюджета.
//⦁	От 5 до 9 – 60% от бюджета.
//⦁	От 10 до 24 – 50% от бюджета.
//⦁	От 25 до 49 – 40% от бюджета.
//⦁	50 или повече – 25% от бюджета.
        if (countPeople >= 1 && countPeople <= 4) {
            transportPrice = budget * 0.75;
        } else if (countPeople >= 5 && countPeople <= 9) {
            transportPrice = budget * 0.60;
        } else if (countPeople >= 10 && countPeople <= 24) {
            transportPrice = budget * 0.50;
        } else if (countPeople >= 25 && countPeople <= 49) {
            transportPrice = budget * 0.40;
        } else if (countPeople >= 50) {
            transportPrice = budget * 0.25;
        }
        double ticketPrice = price * countPeople;
        double difference = Math.abs(budget - (transportPrice + ticketPrice));

        if ((budget - transportPrice) >= ticketPrice) {
            System.out.printf("Yes! You have %.2f leva left.", difference);
        }else {
            System.out.printf("Not enough money! You need %.2f leva.",difference);
        }
    }
}
