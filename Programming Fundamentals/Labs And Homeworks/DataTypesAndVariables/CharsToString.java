package dataTypesAndVariables;

import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        char thirdChar = scanner.nextLine().charAt(0);
        String output = String.format("%c%c%c", firstChar, secondChar, thirdChar);
        System.out.println(output);


    }
}
