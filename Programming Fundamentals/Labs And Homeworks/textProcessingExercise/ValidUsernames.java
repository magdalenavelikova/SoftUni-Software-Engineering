package textProcessingExercise;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split(", ");

        for (String password : inputLine) {
            boolean isValidPassword = true;
            if (password.length() >= 3 && password.length() <= 16) {
                for (int i = 0; i < password.length(); i++) {
                    char currentChar = password.charAt(i);
                    if (!Character.isLetterOrDigit(currentChar) && currentChar != '-' && currentChar != '_') {
                        isValidPassword = false;
                        break;
                    }
                }
            } else {
                isValidPassword = false;
            }
            if (isValidPassword) {
                System.out.println(password);
            }
        }

    }
}
