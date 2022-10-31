package associativeArraysExercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replaceAll(" ", "");
        Map<Character, Integer> occurrencesByChar = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            Character currentChar = input.charAt(i);
            occurrencesByChar.putIfAbsent(currentChar, 0);
            int counter = occurrencesByChar.get(currentChar);
            occurrencesByChar.put(currentChar, counter + 1);
        }

        for (Map.Entry<Character, Integer> entry : occurrencesByChar.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
