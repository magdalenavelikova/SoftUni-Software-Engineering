package archive;

import java.util.Scanner;

public class KarateStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());

        int punch = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '>' & punch > 0) {
                input.deleteCharAt(i);
                punch--;
                i--;
            } else if (input.charAt(i) == '>') {
                punch += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
            }
        }
        System.out.println(input);

    }
}
