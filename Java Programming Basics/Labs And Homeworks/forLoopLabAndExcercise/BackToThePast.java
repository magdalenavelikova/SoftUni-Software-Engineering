package forLoopLabAndExcercise;

import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Наследените пари – реално число в интервала [1.00 ... 1 000 000.00]
        //Годината, до която трябва да живее (включително) – цяло число в интервала [1801 ... 1900]
        double inheritance = Double.parseDouble(scanner.nextLine());
        int finalYear = Integer.parseInt(scanner.nextLine());
        int initialYear = 1800;
        int countYear = 17;
        double costs = 0;
        for (int i = initialYear; i <= finalYear; i++) {
            countYear += 1;
            if (i % 2 == 0) {
                costs += 12000;
            } else {
                costs += 12000 + (50 * countYear);
            }

        }
        if (inheritance >= costs) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", inheritance - costs);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", costs - inheritance);
        }

    }
}
