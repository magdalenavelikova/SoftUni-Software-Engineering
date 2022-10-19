package dataTypesAndVariables;

import java.util.Scanner;

public class CenturiestoMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int centures = Integer.parseInt(scanner.nextLine());
        double years = centures * 100;
        double days = years * 365.2422;
        double hours = days * 24;
        double minutes = hours * 60;
        System.out.printf("%d centuries = %.0f years = %.0f days = %.0f hours = %.0f minutes", centures, years, days, hours, minutes);

//1 centuries = 100 years = 36524 days = 876581 hours = 52594877 minutes
    }
}
