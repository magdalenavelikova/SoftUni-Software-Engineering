package conditionalStatementsLabAndExcercise;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//⦁	Първият ред – броят младши велосипедисти. Цяло число в интервала [1…100]
//⦁	Вторият ред – броят старши велосипедисти. Цяло число в интервала [1… 100]
//⦁	Третият ред – вид трасе – "trail", "cross-country", "downhill" или "road"
        int juniorBikers = Integer.parseInt(scanner.nextLine());
        int seniorBikers = Integer.parseInt(scanner.nextLine());
        String route = scanner.nextLine();
        double priceJuniors = 0;
        double priceSeniors = 0;
       // double discount = 1;

        switch (route) {
            case "trail":
                priceJuniors = 5.5;
                priceSeniors = 7;
                break;
            case "cross-country":
                priceJuniors = 8;
                priceSeniors = 9.5;
                break;
            case "downhill":
                priceJuniors = 12.25;
                priceSeniors = 13.75;
                break;
            case "road":
                priceJuniors = 20;
                priceSeniors = 21.5;
                break;

        }
        double amount = (juniorBikers * priceJuniors) + (seniorBikers * priceSeniors);
        double realProfit = amount;
        if ("cross-country".equals(route) && (seniorBikers + juniorBikers >= 50)) {
            //discount = 0.25;
            realProfit = amount - (amount * 0.25);
        }

        double donations = realProfit - (realProfit * 0.05);
        System.out.printf("%.2f", donations);
    }
}
