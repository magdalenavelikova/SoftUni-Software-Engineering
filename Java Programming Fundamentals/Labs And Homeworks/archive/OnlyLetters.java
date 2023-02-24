package archive;

import java.util.Scanner;

public class OnlyLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder onlyLetters = new StringBuilder();
        int counterForDigit = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                counterForDigit++;
            } else {
                if (counterForDigit > 0) {
                    onlyLetters.append(input.charAt(i));
                    onlyLetters.append(input.charAt(i));
                    counterForDigit = 0;
                } else {
                    onlyLetters.append(input.charAt(i));
                }
            }


        }
        if (counterForDigit > 0) {
            for (int i = input.length() - counterForDigit; i < input.length(); i++) {
                onlyLetters.append(input.charAt(i));

            }
        }
        System.out.println(onlyLetters);
    }
}
