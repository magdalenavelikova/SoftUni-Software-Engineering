package textProcessingLab;

import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();
        for (int i = 0; i < inputLine.length(); i++) {
            int ascii = inputLine.charAt(i);
            if (Character.isDigit(inputLine.charAt(i))) {
                digits.append(inputLine.charAt(i));
            } else if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) {
                letters.append(inputLine.charAt(i));
            } else {
                others.append(inputLine.charAt(i));
            }
        }
        System.out.println(digits.toString());
        System.out.println(letters.toString());
        System.out.println(others.toString());
    }
}
