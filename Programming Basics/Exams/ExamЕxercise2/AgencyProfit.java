package ExamineЕxercise2;

import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {
//Име на авиокомпанията - текст
//Брой билети за	 възрастни – цяло число в диапазона [1…400]
//Брой детски билети – цяло число в диапазона [25…120]
//Нетна цена на билет за възрастен – реално число в диапазона [100.0…1600.0]
//Цената на такса обслужване - реално число в диапазона [10.0…50.0]
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
