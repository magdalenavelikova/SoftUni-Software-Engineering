package whileLabAndExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double vacationSum = Double.parseDouble(scanner.nextLine());
        double currentBalance = Double.parseDouble(scanner.nextLine());
        int countDays = 0;
        int countSpendDays = 0;
        boolean isMoneySpend = false;

        while (currentBalance < vacationSum) {
            String command = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());
            countDays++;
            if (command.equals("save")) {
                currentBalance += money;
                countSpendDays = 0;
            } else {
                currentBalance -= money;
                countSpendDays++;
            }
            if (currentBalance < 0) {
                currentBalance = 0;
            }
            if (countSpendDays >= 5) {
                isMoneySpend = true;
                break;

            }


        }
        if (isMoneySpend) {
            System.out.println("You can't save the money.");
            System.out.println(countDays);
        } else {
            System.out.printf("You saved the money for %d days.", countDays);
        }
    }
}
