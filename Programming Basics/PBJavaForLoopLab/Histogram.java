package PBJavaForLoopLab;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int countToTwoHundred = 0;
        int countToFourHundred = 0;
        int countToSixHundred = 0;
        int countToEightHundred = 0;
        int others = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 200) {
                countToTwoHundred += 1;
            } else if (number < 400) {
                countToFourHundred += 1;
            } else if (number < 600) {
                countToSixHundred += 1;
            } else if (number < 800) {
                countToEightHundred += 1;
            } else if (number >= 800)
                others += 1;
        }

        double percentTo200 = (countToTwoHundred / (n * 1.0)) * 100;
        double percentTo400 = (countToFourHundred / (n * 1.0)) * 100;
        double percentTo600 = (countToSixHundred / (n * 1.0)) * 100;
        double percentTo800 = (countToEightHundred / (n * 1.0)) * 100;
        double percentTo1000 = (others / (n * 1.0)) * 100;
        System.out.printf("%.2f", percentTo200);
        System.out.println("%");
        System.out.printf("%.2f", percentTo400);
        System.out.println("%");
        System.out.printf("%.2f", percentTo600);
        System.out.println("%");
        System.out.printf("%.2f", percentTo800);
        System.out.println("%");
        System.out.printf("%.2f", percentTo1000);
        System.out.println("%");
    }
}
