package BasicSyntaxExercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        int number = Integer.parseInt(inputLine);
        int sum = 0;
        boolean isStrong = false;
        for (int i = 0; i < inputLine.length(); i++) {
            int digit = number % 10;
            int factorial = 1;
            for (int j = 1; j < digit; j++) {
                factorial += factorial * j;
            }
            sum += factorial;
            number = number / 10;
        }
        if (sum == Integer.parseInt(inputLine)) {
            isStrong = true;
        }

        if (isStrong) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
