package methodsLab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputType = scanner.nextLine();
        switch (inputType) {
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                System.out.println(getMaxValue(firstChar, secondChar));
                break;
            case "int":
                int firstNumber = Integer.parseInt(scanner.nextLine());
                int secondNumber = Integer.parseInt(scanner.nextLine());
                System.out.println(getMaxValue(firstNumber, secondNumber));
                break;
            case "string":
                String firstString = scanner.nextLine();
                String secondString = scanner.nextLine();
                System.out.println(getMaxValue(firstString, secondString));
                break;

        }
    }

    private static char getMaxValue(char first, char second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }

    private static int getMaxValue(int first, int second) {
        return Math.max(first, second);
    }

    private static String getMaxValue(String first, String second) {
        if (first.compareTo(second)>=0) {
            return first;
        } else {
            return second;
        }

    }
}
