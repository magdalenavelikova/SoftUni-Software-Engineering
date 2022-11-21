package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "([|#])(?<name>[A-Za-z ]+)\\1(?<date>[\\d]{2}\\/[\\d]{2}\\/[\\d]{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int calories = 0;
        List<String> food = new ArrayList<>();
        while (matcher.find()) {
            food.add("Item: " + matcher.group("name") +
                    ", Best before: " + matcher.group("date") +
                    ", Nutrition: " + matcher.group("calories"));
            calories += Integer.parseInt(matcher.group("calories"));


        }
        System.out.printf("You have food to last you for: %d days!%n", calories / 2000);
        for (String s : food) {
            System.out.println(s);
        }

    }
}
