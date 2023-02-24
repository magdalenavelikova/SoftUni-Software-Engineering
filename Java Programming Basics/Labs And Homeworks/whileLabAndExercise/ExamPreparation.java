package whileLabAndExercise;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int countMark = Integer.parseInt(scanner.nextLine());
        boolean isEnough = false;
        String command = scanner.nextLine();
//        double grade = Double.parseDouble(scanner.nextLine());
        double totalgrades=0;
        int countTotal=0;
        String lastProblem="";
        while (!command.equals("Enough")) {
           String newProblem=command;
             double grade = Double.parseDouble(scanner.nextLine());
            lastProblem=newProblem;
            if (grade <= 4) {
                count++;

            }
            if (count >= countMark) {
                isEnough = true;
                break;
            }
            totalgrades+=grade;
            countTotal++;
            command = scanner.nextLine();

        }
        if(isEnough){
            System.out.printf("You need a break, %d poor grades.",count);
        } else {
//            ⦁	"Average score: {средна оценка}"
//⦁	"Number of problems: {броя на всички задачи}"
//⦁	"Last problem: {името на последната задача}"
            System.out.printf("Average score: %.2f%n",totalgrades/countTotal);
            System.out.printf("Number of problems: %d%n",countTotal);
            System.out.printf("Last problem: %s",lastProblem);
        }
    }
}
