package methodsExercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);

        System.out.print(getCharactersInRange(firstChar, secondChar));
    }

    private static String getCharactersInRange(char start, char end) {
        String result = "";
        int firstChar = 0;
        int secondChar = 0;
        if (start < end) {
            firstChar = start;
            secondChar = end;
        } else {
            firstChar = end;
            secondChar = start;
        }

        for (int i = firstChar + 1; i < secondChar; i++) {
            result += (char) i + " ";

        }
        return result;

    }
}
