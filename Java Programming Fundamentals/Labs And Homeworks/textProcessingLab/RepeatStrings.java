package textProcessingLab;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        for (String word : words) {
            System.out.print(repeated(word, word.length()));
        }

    }

    public static String repeated(String word, int repeatition) {
        char[] repeated = new char[word.length() * repeatition];
        for (int i = 0; i < repeated.length; i++) {
            repeated[i] = word.charAt(i % word.length());
        }
        return new String(repeated);
    }


}
