package MidExam;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int employeeEfficiencyPerHour = firstEmployeeEfficiency + secondEmployeeEfficiency + thirdEmployeeEfficiency;
        int time = 0;
        if ((studentsCount % employeeEfficiencyPerHour) == 0) {
            time = studentsCount / employeeEfficiencyPerHour;
        } else {
            time = (studentsCount / employeeEfficiencyPerHour) + 1;
        }
        if (time > 3 && time % 3 == 0) {
            time += time / 3 - 1;

        } else if (time > 3) {
            time += time / 3;
        }
        System.out.printf("Time needed: %dh.", time);
    }
}
