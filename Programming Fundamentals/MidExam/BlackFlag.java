package MidExam;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double gainedPlunder = 0;
        int counter = 0;
        while (counter < days) {
            counter++;
            gainedPlunder += dailyPlunder;
            if (counter % 3 == 0) {
                gainedPlunder += (dailyPlunder * 0.5);
            }
            if (counter % 5 == 0) {
                gainedPlunder = gainedPlunder * 0.70;
            }
        }

        if (gainedPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", gainedPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", gainedPlunder / expectedPlunder * 100);
        }

    }
}
