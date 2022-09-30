package MethodsExercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            System.out.println(isPalindromeNumber(input));
            input = scanner.nextLine();
        }
    }
    private static boolean isPalindromeNumber(String number) {
        String reverseString = "";
        for (int j = number.length() - 1; j >= 0; j--) {
            reverseString += number.charAt(j);
        }
        return number.equals(reverseString);
    }

}
