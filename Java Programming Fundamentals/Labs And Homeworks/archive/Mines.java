package archive;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        String regex = "<..>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input.toString());
        while (matcher.find()) {
            int first = matcher.group().charAt(1);
            int second = matcher.group().charAt(2);
            int strength = Math.abs(first - second);
            int index = input.indexOf(matcher.group());
            int startIndex = index - strength;
            int endIndex = index - 1 + strength + 4;
            if (startIndex < 0) {
                startIndex = 0;
            }
            if (endIndex >= input.length()) {
                endIndex = input.length() - 1;
            }
            for (int i = startIndex; i <= endIndex; i++) {
                input.setCharAt(i, '_');
            }

        }
        System.out.println(input);
    }

}
