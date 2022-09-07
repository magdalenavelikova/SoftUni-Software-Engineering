package ExamineExercise1;

import java.util.Scanner;

public class DailyEarnings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        На първия ред – работни дни в месеца. Цяло число в интервала [5 … 30].
//        На втория ред – изкарани пари на ден. Реално число в интервала [10.00 … 2000.00].
//        На третия ред – курсът на долара спрямо лева /1 долар = X лева/. Реално число в интервала [0.99 … 1.99].
        int days = Integer.parseInt(scanner.nextLine());
        double salaryPerDay = Double.parseDouble(scanner.nextLine());
        double exchange = Double.parseDouble(scanner.nextLine());
        double salaryPerYear = (salaryPerDay * days) * 12;
        double bonus = 2.5 * (salaryPerDay * days);
        double taxes = (salaryPerYear+bonus)*.25;
        double amount = salaryPerYear + bonus - taxes;
        double salaryPerDayLv=(amount/365)*exchange;
        System.out.printf("%.2f",salaryPerDayLv);
    }
}
