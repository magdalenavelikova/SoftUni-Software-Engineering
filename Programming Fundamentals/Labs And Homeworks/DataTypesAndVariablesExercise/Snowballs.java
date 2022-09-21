package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double snowballValueMax = Double.MIN_VALUE;
        int snowballSnowMax = 0;
        int snowballTimeMax = 0;
        int snowballQualityMax = 0;
        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double snowballValue = 1;
            snowballValue *= Math.pow((snowballSnow / snowballTime), snowballQuality);

            if (snowballValue >= snowballValueMax) {
                snowballQualityMax = snowballQuality;
                snowballSnowMax = snowballSnow;
                snowballTimeMax = snowballTime;
                snowballValueMax = snowballValue;

            }


        }
        System.out.printf("%d : %d = %.0f (%d)", snowballSnowMax, snowballTimeMax, snowballValueMax, snowballQualityMax);

    }
}
