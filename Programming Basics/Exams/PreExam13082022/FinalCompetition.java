package PreExam13082022;

import java.util.Scanner;

public class FinalCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dancers = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();
        double awardAmount = dancers * points;
        double percentCosts = 0;

        switch (place) {
            case "Bulgaria":
                if (season.equals("summer")) {
                    percentCosts = 0.05;
                } else if (season.equals("winter")) {
                    percentCosts = 0.08;
                }
                break;
            case "Abroad":
                if (season.equals("summer")) {
                    percentCosts = 0.10;
                } else if (season.equals("winter")) {
                    percentCosts = 0.15;
                }
                awardAmount += awardAmount / 2;
                break;

        }
        double amount = awardAmount - (awardAmount * percentCosts);
        double charityAmount = amount * 0.75;
        double moneyPerPerson = (amount - charityAmount) / dancers;
        System.out.printf("Charity - %.2f%n", charityAmount);
        System.out.printf("Money per dancer - %.2f", moneyPerPerson);
    }
}
