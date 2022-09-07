package JavaConditionalStatementsAdvanced;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int timeFirst = Integer.parseInt(scanner.nextLine());
        int timeSecond = Integer.parseInt(scanner.nextLine());
        int timeThird = Integer.parseInt(scanner.nextLine());
        int timeSum = timeFirst + timeSecond + timeThird;
        int min = timeSum / 60;
        // double second = timeSum % 60.;
        int second = timeSum % 60;
        if (second > 9) {
            // System.out.printf("%d" + ":" + "%.0f", min, second);
            System.out.printf("%d:%d", min, second);
            //друг начин да укажем че искаме 2 разряда
            //   System.out.printf("%d:%02d",min,second);
        } else {
            // System.out.printf("%d" + ":" + "0" + "%.0f", min, second);
            System.out.printf("%d:0%d", min, second);
        }
        System.out.println();
        //друг начин да укажем че искаме 2 разряда
       System.out.printf("%d:%02d", min, second);
    }
}
