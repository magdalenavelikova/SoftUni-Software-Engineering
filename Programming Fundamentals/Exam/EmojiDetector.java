package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(::|\\*\\*)(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> validEmojis = new ArrayList<>();

        while (matcher.find()) {
            validEmojis.add(matcher.group());
        }
        long coolThreshold = 1;
        pattern = Pattern.compile("\\d");
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            coolThreshold *= Integer.parseInt(matcher.group());
        }

        System.out.println("Cool threshold: " + coolThreshold);
        System.out.println(validEmojis.size() + " emojis found in the text. The cool ones are:");
        for (String entry : validEmojis) {
            int amount = 0;
            for (int i = 2; i < entry.length() - 2; i++) {
                amount += entry.charAt(i);

            }
            if (amount >= coolThreshold) {
                System.out.println(entry);
            }
        }

    }
}
