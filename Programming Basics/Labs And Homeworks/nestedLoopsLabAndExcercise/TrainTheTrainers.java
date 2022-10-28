package nestedLoopsLabAndExcercise;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jury = Integer.parseInt(scanner.nextLine());
        String namePresentation = scanner.nextLine();
        double allGrade = 0;

        int count = 0;
        double averageGrade = 0;
        while (!namePresentation.equals("Finish")) {
            count++;
            double grades=0;
            for (int i = 0; i < jury; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                grades += grade;
                averageGrade = grades / jury;

            }
            System.out.printf("%s - %.2f.%n",namePresentation,averageGrade);
            allGrade+=averageGrade;
            namePresentation = scanner.nextLine();

        }
        System.out.printf("Student's final assessment is %.2f.",allGrade/count);
    }
}
