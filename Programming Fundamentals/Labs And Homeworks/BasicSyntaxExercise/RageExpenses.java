package BasicSyntaxExercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());
        int countHeadset = lostGamesCount / 2;
        int countMouse = lostGamesCount / 3;
        int countKeyboard = lostGamesCount / 6;
        int countDisplay = countKeyboard / 2;
        double amount = countHeadset * headsetPrice;
        amount += countMouse * mousePrice;
        amount += countKeyboard * keyboardPrice;
        amount += countDisplay * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.", amount);

    }
}

