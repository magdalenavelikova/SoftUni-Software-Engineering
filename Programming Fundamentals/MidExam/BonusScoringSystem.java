package MidExam;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = Double.MIN_VALUE;
        int attendancesForMax = 0;
        for (int i = 0; i < students; i++) {
            int attendances = Integer.parseInt(scanner.nextLine());
            double totalBonus = (attendances*1.0 / lectures) * (5 + bonus);
            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                attendancesForMax = attendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", attendancesForMax);
    }
}
