package workingWithAbstraction.hotelReservation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] reservation=scanner.nextLine().split("\\s+");
        double pricePerDay=Double.parseDouble(reservation[0]);
        int numberOfDays=Integer.parseInt(reservation[1]);
        Season season=Season.parse(reservation[2]);
        Discount discountType= Discount.parse(reservation[3]);

        PriceCalculator priceCalculator=new PriceCalculator(pricePerDay,numberOfDays,season,discountType);

        System.out.printf("%.2f%n",priceCalculator.getPricePerHoliday());

//pricePerDay} {numberOfDays} {season} {discountType}",

    }
}
