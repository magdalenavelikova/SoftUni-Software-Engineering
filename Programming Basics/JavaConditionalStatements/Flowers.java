package JavaConditionalStatements;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//⦁	На първия ред е броят на закупените хризантеми – цяло число в интервала [0 ... 200]
//⦁	На втория ред е броят на закупените рози – цяло число в интервала [0 ... 200]
//⦁	На третия ред е броят на закупените лалета – цяло число в интервала [0 ... 200]
//⦁	На четвъртия ред е посочен сезона – [Spring, Summer, Аutumn, Winter]
//⦁	На петия ред е посочено дали денят е празник – [Y – да / N - не]
        int chrysanthemums = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int tulip = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();
        boolean isHoliday = "Y".equals(holiday);
        double priceChrysanthemums = 0;
        double priceRoses = 0;
        double priseTulip = 0;
        double bouquetChrysanthemums = 0;
        double bouquetRoses = 0;
        double bouquetTulip = 0;
        switch (season) {
            case "Spring":
            case "Summer":
                priceChrysanthemums = 2;
                priceRoses = 4.1;
                priseTulip = 2.5;
                break;
            case "Autumn":
            case "Winter":
                priceChrysanthemums = 3.75;
                priceRoses = 4.5;
                priseTulip = 4.15;
                break;
        }
        bouquetRoses = priceRoses * roses;
        bouquetTulip = priseTulip * tulip;
        bouquetChrysanthemums = chrysanthemums * priceChrysanthemums;
        double priceAll = bouquetChrysanthemums + bouquetRoses + bouquetTulip;
        if (isHoliday) {
            priceAll = priceAll * 1.15;

        }

        if (tulip > 7 && "Spring".equals(season)) {
            priceAll = priceAll - (priceAll * 0.05);
        }
        if (roses >= 10 && "Winter".equals(season)) {
            priceAll = priceAll - (priceAll * 0.10);
        }

        if ((roses + chrysanthemums + tulip) > 20) {
            priceAll = priceAll - (priceAll * 0.2);
        }
        System.out.printf("%.2f", priceAll + 2.);


    }
}
