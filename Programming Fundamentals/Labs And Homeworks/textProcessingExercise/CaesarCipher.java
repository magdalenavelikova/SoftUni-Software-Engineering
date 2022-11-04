package textProcessingExercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int currentChar = input.charAt(i);
            int encryptedChar = currentChar + 3;
            encrypted.append((char) encryptedChar);
        }
        System.out.println(encrypted);
    }
}
