package finalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        String regex = "(\\|)(?<bossName>[A-Z]{4,})\\1:#(?<title>[A-Za-z]+\\s[A-Za-z]+)#";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < row; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                System.out.println(matcher.group("bossName") + ", The " + matcher.group("title"));
                System.out.println(">> Strength: " + matcher.group("bossName").length());
                System.out.println(">> Armor: " + matcher.group("title").length());
            } else {
                System.out.println("Access denied!");
            }
        }


    }
}
