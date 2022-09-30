package MethodsLab;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String commandLine = scanner.nextLine();
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        switch (commandLine) {
            case "add":
                System.out.println(add(number1, number2));
                break;
            case "multiply":
                System.out.println(multiply(number1, number2));
                break;
            case "subtract":
                System.out.println(subtract(number1, number2));
                break;
            case "divide":
                System.out.println(divide(number1, number2));

                break;
        }
    }

    public static int add(int number1, int number2) {

        return number1 + number2;
    }

    public static int divide(int number1, int number2) {

        return number1 / number2;
    }

    public static int subtract(int number1, int number2) {

        return number1 - number2;
    }

    public static int multiply(int number1, int number2) {

        return number1 * number2;
    }
}
