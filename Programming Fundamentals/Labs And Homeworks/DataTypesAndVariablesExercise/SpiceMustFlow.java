package dataTypesAndVariablesExercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int yeld = startingYield;
        int countDays = 0;
        int total = 0;
        while (yeld >= 100) {
            int spices = yeld;
            countDays++;
            yeld -= 10;
            spices -= 26;
            total += spices;
        }

        if (total > 0) {
            total -= 26;
        }
        System.out.println(countDays);
        System.out.println(total);

    }
}
