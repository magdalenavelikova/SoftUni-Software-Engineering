package conditionalStatementsLabAndExcercise;

import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//⦁	Сезонът – текст - “Winter”, “Spring” или “Summer”;
//⦁	Видът на групата – текст - “boys”, “girls” или “mixed”;
//⦁	Брой на учениците – цяло число в интервала [1 … 10000];
//⦁	Брой на нощувките – цяло число в интервала [1 … 100].
        String season = scanner.nextLine();
        String typeOfGroup = scanner.nextLine();
        int students = Integer.parseInt(scanner.nextLine());
        int overnights = Integer.parseInt(scanner.nextLine());
        double price = 0;
        String sport = "";
        if ("Winter".equals(season)) {
            if ("boys".equals(typeOfGroup)) {
                price = 9.6;
                sport = "Judo";
            } else if ("girls".equals(typeOfGroup)) {
                price = 9.6;
                sport = "Gymnastics";
            } else if ("mixed".equals(typeOfGroup)) {
                price = 10;
                sport = "Ski";
            }
        } else if ("Spring".equals(season)) {
            if ("boys".equals(typeOfGroup)) {
                price = 7.2;
                sport = "Tennis";
            } else if ("girls".equals(typeOfGroup)) {
                price = 7.2;
                sport = "Athletics";
            } else if ("mixed".equals(typeOfGroup)) {
                price = 9.5;
                sport = "Cycling";
            }
        } else if ("Summer".equals(season)) {
            if ("boys".equals(typeOfGroup)) {
                price = 15;
                sport = "Football";
            } else if ("girls".equals(typeOfGroup)) {
                price = 15;
                sport = "Volleyball";
            } else if ("mixed".equals(typeOfGroup)) {
                price = 20;
                sport = "Swimming";
            }
        }
        double amount = students * overnights * price;
        if (students >= 10 && students<20) {
            amount = amount - (amount * 0.05);

        } else if (students >= 20 && students<50) {
            amount = amount - (amount * 0.15);

        } else if (students >= 50) {
            amount = amount - (amount * 0.50);

        }
        System.out.printf("%s %.2f lv.",sport,amount);

    }
}
