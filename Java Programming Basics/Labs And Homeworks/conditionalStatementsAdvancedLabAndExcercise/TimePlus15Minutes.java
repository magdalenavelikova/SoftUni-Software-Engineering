package conditionalStatementsAdvancedLabAndExcercise;

import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int sumMinutes = minutes + 15;
        if (sumMinutes >= 60) {
            hour = hour + 1;
            if (hour >= 24) {
                hour = hour - 24;
            }
            minutes = sumMinutes - 60;
            System.out.printf("%d:%02d", hour, minutes);
        } else {

            System.out.printf("%d:%02d", hour, sumMinutes);
        }
    }
}
