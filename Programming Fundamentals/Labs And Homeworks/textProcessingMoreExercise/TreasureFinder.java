package textProcessingMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] keys = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        while (!input.equals("find")) {
            StringBuilder string = new StringBuilder(input);

            for (int i = 0; i < string.length(); i++) {

                for (int key : keys) {
                    char currentChar = string.charAt(i);
                    currentChar -= key;
                    string.setCharAt(i, Character.valueOf(currentChar));
                    i++;
                    if (i == string.length()) {
                        break;
                    }
                }
                i--;
            }
            System.out.printf("Found %s at %s%n",
                    string.substring(string.indexOf("&") + 1, string.lastIndexOf("&")),
                    string.substring(string.indexOf("<") + 1, string.lastIndexOf(">")));
            input = scanner.nextLine();
        }
    }
}
