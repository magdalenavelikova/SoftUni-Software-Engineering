package dataTypesAndVariablesExercise;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int lastDigit = number % 10;
        int sum = 0;

        while (number > 0) {
            sum += lastDigit;
            number = number / 10;
            lastDigit = number % 10;
        }
        System.out.println(sum);
    }
}
