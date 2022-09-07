package JavaConditionalStatements;

import java.util.Scanner;

public class OnTimeForTheExam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//               ⦁	Първият ред съдържа час на изпита – цяло число от 0 до 23.
//⦁	Вторият ред съдържа минута на изпита – цяло число от 0 до 59.
//⦁	Третият ред съдържа час на пристигане – цяло число от 0 до 23.
//⦁	Четвъртият ред съдържа минута на пристигане – цяло число от 0 до 59.
        int examineHours = Integer.parseInt(scanner.nextLine());
        int examineMinutes = Integer.parseInt(scanner.nextLine());
        int arriveHours = Integer.parseInt(scanner.nextLine());
        int arriveMinutes = Integer.parseInt(scanner.nextLine());

        int examineTime = examineHours * 60 + examineMinutes;
        int arrivalTime = arriveHours * 60 + arriveMinutes;
        int diff = Math.abs(examineTime - arrivalTime);
        int hours = diff / 60;
        int minutes = diff % 60;

        if (examineTime < arrivalTime) {
            System.out.println("Late");
            if (diff < 60) {
                System.out.printf("%d minutes after the start", diff);
            } else{
                System.out.printf("%d:%02d hours after the start",hours,minutes);
            }

        } else if (diff <= 30 || examineTime == arrivalTime) {
            System.out.println("On time");
            if (diff>0){
                System.out.printf("%d minutes before the start", diff);

            }

        } else {
            System.out.println("Early");
            if (diff < 60) {
                System.out.printf("%d minutes before the start", diff);
            } else{
                System.out.printf("%d:%02d hours before the start",hours,minutes);
            }
        }


    }
}
