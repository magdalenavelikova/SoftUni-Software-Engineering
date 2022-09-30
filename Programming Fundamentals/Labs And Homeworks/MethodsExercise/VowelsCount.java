package MethodsExercise;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        printVowelsCount(input);
    }

    private static void printVowelsCount(String text) {
        int counter = 0;
        for (char element : text.toCharArray()) {
            if (element == 'a' || element == 'o'|| element == 'e' || element == 'i' || element == 'u') {
                counter++;
            }
        }
        System.out.println(counter);
    }

}
