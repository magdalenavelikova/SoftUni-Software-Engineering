package PBJavaForLoopLab;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        int countStudentsTo3 = 0;
        int countStudentsTo4 = 0;
        int countStudentsTo5 = 0;
        int countStudentsTo6 = 0;
        double gradeForAll=0;
        for (int i = 0; i < students; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            gradeForAll +=grade;
            if (grade <= 2.99) {
                countStudentsTo3 += 1;
            } else if (grade <= 3.99) {
                countStudentsTo4 += 1;
            } else if (grade <= 4.99) {
                countStudentsTo5 += 1;
            } else {
                countStudentsTo6 += 1;
            }

        }
        double percentTo3=(countStudentsTo3/(students*1.0))*100;
        double percentTo4=(countStudentsTo4/(students*1.0))*100;
        double percentTo5=(countStudentsTo5/(students*1.0))*100;
        double percentTo6=(countStudentsTo6/(students*1.0))*100;


        System.out.printf("Top students: %.2f",percentTo6);
        System.out.println("%");
        System.out.printf("Between 4.00 and 4.99: %.2f",percentTo5);
        System.out.println("%");
        System.out.printf("Between 3.00 and 3.99: %.2f",percentTo4);
        System.out.println("%");
        System.out.printf("Fail: %.2f",percentTo3);
        System.out.println("%");
        System.out.printf("Average: %.2f",gradeForAll/students);


    }
}
