package setsAndMapsAdvancedExcersise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class CountSymbols {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> symbolMap = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (!symbolMap.containsKey(input.charAt(i))) {
                symbolMap.put(input.charAt(i), 1);
            } else {
                symbolMap.put(input.charAt(i), symbolMap.get(input.charAt(i)) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : symbolMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");

        }

    }
}
