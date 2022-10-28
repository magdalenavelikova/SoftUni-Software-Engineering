package whileLabAndExercise;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double change = Double.parseDouble(scanner.nextLine());
        double sumCoins = 0.0;
        int countCoins=0;
        while ((change > 0)) {
            if (change >= 2.00) {
                sumCoins += 2.00;
            } else if (change >= 1.00) {
                sumCoins += 1.00;
            } else if (change >= 0.50) {
                sumCoins += 0.50;
            } else if (change >= 0.20) {
                sumCoins += 0.20;
            } else if (change >= 0.10) {
                sumCoins += 0.10;
            } else if (change >= 0.05) {
                sumCoins += 0.05;
            } else if (change >= 0.02) {
                sumCoins += 0.02;
            } else if (change >= 0.01) {
                sumCoins += 0.01;
            }
            countCoins++;
            change=change-sumCoins;
            change=Math.round(change * 100.0) / 100.0;
            sumCoins=0;
        }
        System.out.println(countCoins);
    }
}
