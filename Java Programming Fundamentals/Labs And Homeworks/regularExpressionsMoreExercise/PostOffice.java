package regularExpressionsMoreExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|");
        String firstPart = getPattern(input[0]);
        if (!firstPart.equals("no")) {
            for (int i = 0; i < firstPart.length(); i++) {
                int current = firstPart.charAt(i);
                String regex = "(?<asciiCode>[0-9]{2}):(?<length>[0-9]{2})";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input[1]);
                while (matcher.find()) {
                    if (Integer.parseInt(matcher.group("asciiCode")) == current) {
                        int length = Integer.parseInt(matcher.group("length")) + 1;
                        String[] text = input[2].split("\\s+");
                        Arrays.stream(text)
                                .filter(s -> s.length() == length && s.charAt(0) == (char) (current))
                                .forEach(s -> System.out.println(s));
                        break;
                    }
                }
            }
        }
    }

    private static String getPattern(String input) {
        String regex = "([#$%*&])(?<valid>[A-Z]+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group("valid");
        }
        return "no";
    }
}
