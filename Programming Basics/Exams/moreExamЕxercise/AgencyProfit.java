package moreExamЕxercise;

import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String companyName = scanner.nextLine();
        int adultTicket = Integer.parseInt(scanner.nextLine());
        int kidTicket = Integer.parseInt(scanner.nextLine());
        double priceAdultTicket = Double.parseDouble(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());
        double priceKidTicket = priceAdultTicket-(priceAdultTicket * 0.70);
        double adultTicketsAmount = adultTicket * (priceAdultTicket + tax);
        double kidTicketsAmount = kidTicket * (priceKidTicket + tax);
        double amount = adultTicketsAmount + kidTicketsAmount;
        double profit = amount * 0.2;
        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", companyName, profit);

    }
}
