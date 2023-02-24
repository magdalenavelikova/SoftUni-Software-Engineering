package regularExpressionsMoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase().trim();

        String regex = "(?<nonDigit>\\D+)(?<digit>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            int digit = Integer.parseInt(matcher.group("digit"));
            String nonDigit = matcher.group("nonDigit");
            for (int i = 0; i < digit; i++) {
                sb.append(nonDigit);
            }
        }
        System.out.printf("Unique symbols used: %d%n", sb.chars().distinct().count());
        System.out.println(sb);

    }


}
