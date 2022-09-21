package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;
import java.util.regex.Pattern;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            if (isBoolean(input)) {
                System.out.println(input + " is boolean type");
            } else if (isInteger(input)) {
                System.out.println(input + " is integer type");
            } else if (isFloat(input)) {
                System.out.println(input + " is floating point type");
            } else if (isChar(input)) {
                System.out.println(input + " is character type");
            } else  {
                System.out.println(input + " is string type");
            }

            input = scanner.nextLine();
        }
    }

    public static boolean isBoolean(String input) {
        if (input.toLowerCase().equals("true") || input.toLowerCase().equals("false")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isInteger(String input) {
        Pattern pattern = Pattern.compile("[+-]?[0-9][0-9]*");
        boolean result = pattern.matcher(input).matches();
        return result;
    }

    public static boolean isFloat(String input) {
        Pattern pattern = Pattern.compile("[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?");
        boolean result = pattern.matcher(input).matches();
        return result;
    }

    public static boolean isChar(String input) {
        Pattern pattern = Pattern.compile("[^0-9]");
        boolean result = pattern.matcher(input).matches();
        if (result && input.length() == 1) {
            return true;
        } else {
            return false;
        }
    }


}
