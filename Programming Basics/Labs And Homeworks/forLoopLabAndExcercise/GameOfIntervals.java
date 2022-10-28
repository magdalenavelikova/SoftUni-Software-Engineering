package forLoopLabAndExcercise;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int move = Integer.parseInt(scanner.nextLine());
        double countNumberTo9 = 0;
        double countNumberTo19 = 0;
        double countNumberTo29 = 0;
        double countNumberTo39 = 0;
        double countNumberTo50 = 0;
        double countInvalid = 0;
        double points = 0;
        int countAllNumbers = 0;
        for (int i = 0; i < move; i++) {
            int numbers = Integer.parseInt(scanner.nextLine());
            countAllNumbers += 1;
            if (numbers < 0 || numbers > 50) {
                countInvalid += 1;
                points = points / 2;
            } else {
                if (numbers <= 9) {
                    points += numbers * 0.2;
                    countNumberTo9 += 1;
                } else if (numbers <= 19) {
                    points += numbers * 0.3;
                    countNumberTo19 += 1;
                } else if (numbers <= 29) {
                    points += numbers * 0.4;
                    countNumberTo29 += 1;
                } else if (numbers <= 39) {
                    points += 50;
                    countNumberTo39 += 1;
                } else {
                    points += 100;
                    countNumberTo50 += 1;
                }
            }

        }

        System.out.printf("%.2f%n", points);
        System.out.printf("From 0 to 9: %.2f", ((countNumberTo9 / (countAllNumbers * 1.0)) * 100));
        System.out.println("%");
        System.out.printf("From 10 to 19: %.2f", ((countNumberTo19 / (countAllNumbers * 1.0)) * 100));
        System.out.println("%");
        System.out.printf("From 20 to 29: %.2f", ((countNumberTo29 / (countAllNumbers * 1.0)) * 100));
        System.out.println("%");
        System.out.printf("From 30 to 39: %.2f", ((countNumberTo39 / (countAllNumbers * 1.0)) * 100));
        System.out.println("%");
        System.out.printf("From 40 to 50: %.2f", ((countNumberTo50 / (countAllNumbers * 1.0)) * 100));
        System.out.println("%");
        System.out.printf("Invalid numbers: %.2f", ((countInvalid / (countAllNumbers * 1.0)) * 100));
        System.out.println("%");
    }
}
