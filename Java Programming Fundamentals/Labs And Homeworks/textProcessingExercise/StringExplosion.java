package textProcessingExercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder(scanner.nextLine());
        int strength = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != '>' && strength > 0) {
                text.deleteCharAt(i);
                strength--;
                i--;
            } else if (text.charAt(i) == '>') {
                strength += Character.getNumericValue(text.charAt(i + 1));
            }

        }
        System.out.println(text);
    }
}
