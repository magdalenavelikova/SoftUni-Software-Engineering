package JavaConditionalStatements;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = "";
        String destination = "";
        double holidayPrice = 0;
        switch (season) {
            case "summer":
                place = "Camp";
                break;
            case "winter":
                place = "Hotel";
                break;
        }
        if (budget <= 100) {
            destination = "Bulgaria";
            if ("summer".equals(season)) {
                holidayPrice = budget * 0.3;
            } else {
                holidayPrice = budget * 0.7;
            }

        } else if (budget <= 1000) {
            destination = "Balkans";
            if ("summer".equals(season)) {
                holidayPrice = budget * 0.4;
            } else {
                holidayPrice = budget * 0.8;
            }
        } else {
            place = "Hotel";
            destination = "Europe";
            holidayPrice = budget * 0.9;
        }
        System.out.printf("Somewhere in %s %n", destination);
        System.out.printf("%s - %.2f", place, holidayPrice);

    }
}
