package methodsExercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (!IsLengthValid(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!IsStringValid(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!Is2Digit(password)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (Is2Digit(password) && IsStringValid(password) && IsLengthValid(password)) {
            System.out.println("Password is valid");
        }

    }

    private static boolean IsLengthValid(String password) {
       /* boolean isValid = false;
        if (password.length() >= 6 && password.length() <= 10) {
            isValid = true;
        }
        return isValid;*/
        return (password.length() >= 6 && password.length() <= 10);
    }

    private static boolean IsStringValid(String password) {
        boolean isValid = false;
        int counterInvalid = 0;
        for (int i = 0; i < password.length(); i++) {
            int symbol = password.charAt(i);
       /*     if (!((symbol >= 48 && symbol <= 57) || (symbol >= 65 && symbol <= 90) || (symbol >= 97 && symbol <= 122))) {
                counterInvalid++;
            }*/
            if (!Character.isLetterOrDigit(symbol)) {
                counterInvalid++;
            }
        }
        if (counterInvalid == 0) {
            isValid = true;
        }
        return isValid;
    }

    private static boolean Is2Digit(String password) {
        boolean isValid = false;
        int counterDigit = 0;
        for (int i = 0; i < password.length(); i++) {
            int symbol = password.charAt(i);
            if (symbol >= 48 && symbol <= 57) {
                counterDigit++;
            }
        }
       /* if (counterDigit >= 2) {
            isValid = true;
        }*/
        return (counterDigit >= 2);
    }
}
