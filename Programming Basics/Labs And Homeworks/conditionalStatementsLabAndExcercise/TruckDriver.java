package conditionalStatementsLabAndExcercise;

import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        double kmPerMonth = Double.parseDouble(scanner.nextLine());
        double pricePerKm = 0;
        double salary = 0;
//        ⦁	Първи ред – Сезон – текст "Spring", "Summer", "Autumn" или "Winter"
//⦁	Втори ред –  Километри на месец – реално число в интервала [10.00...20000.00]
        if (kmPerMonth <= 5000) {
            if ("Spring".equals(season) || "Autumn".equals(season)) {
                pricePerKm=0.75;
            } else if ("Summer".equals(season)) {
                pricePerKm=0.90;
            } else if ("Winter".equals(season)) {
                pricePerKm=1.05;
            }
        } else if (kmPerMonth <= 10000) {
            if ("Spring".equals(season) || "Autumn".equals(season)) {
                pricePerKm=0.95;
            } else if ("Summer".equals(season)) {
                pricePerKm=1.10;
            } else if ("Winter".equals(season)) {
                pricePerKm=1.25;
            }
        } else if (kmPerMonth <= 20000) {
            pricePerKm = 1.45;
        }
        salary=((kmPerMonth*pricePerKm)*4);
        salary=salary-(salary*0.10);
        System.out.printf("%.2f",salary);

    }
}



