package PreExam13082022;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        int countFail = 0;
        int countBetween3and4 = 0;
        int countBetween4and5 = 0;
        int countTopStudents = 0;
        double allGrades = 0;
        for (int i = 1; i <= students; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade >= 2.00 && grade <= 2.99) {
                countFail++;
            } else if (grade <= 3.99) {
                countBetween3and4++;
            } else if (grade <= 4.99) {
                countBetween4and5++;
            } else {
                countTopStudents++;
            }
            allGrades += grade;
        }
        System.out.printf("Top students: %.2f%%%n", (countTopStudents * 1.0 / students) * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", (countBetween4and5 * 1.0 / students) * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", (countBetween3and4 * 1.0 / students) * 100);
        System.out.printf("Fail: %.2f%%%n", ((countFail * 1.0) / students) * 100);
        System.out.printf("Average: %.2f", allGrades / students);

    }
}
