package dataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < rows; i++) {
            int decryptedChar = 0;
            int charInput = scanner.nextLine().charAt(0);
            decryptedChar = charInput + key;
            System.out.printf("%c", (char) decryptedChar);

        }

    }
}
