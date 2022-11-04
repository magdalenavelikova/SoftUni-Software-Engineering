package textProcessingExercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] word = scanner.nextLine().split("\\s+");
        double sum = 0;

        for (String s : word) {
            char firstLetter = s.charAt(0);
            char lastLetter = s.charAt(s.length() - 1);
            double number = Double.parseDouble(s.substring(1, s.length() - 1));
            if (Character.isLowerCase(firstLetter)) {
                sum += number * getPosition(firstLetter);
            } else {
                sum += number / getPosition(firstLetter);
            }
            if (Character.isLowerCase(lastLetter)) {
                sum += getPosition(lastLetter);
            } else {
                sum -= getPosition(lastLetter);
            }
        }

        System.out.printf("%.2f", sum);
    }

    public static int getPosition(char letter) {
        return Character.toLowerCase(letter) - 96;

    }
}
