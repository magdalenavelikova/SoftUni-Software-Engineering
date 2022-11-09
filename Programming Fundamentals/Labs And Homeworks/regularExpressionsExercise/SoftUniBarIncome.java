package regularExpressionsExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double totalSum = 0;
        while ((!input.equals("end of shift"))) {
            String regex = "@(?<planet>[A-z]+)([^@\\-!:>]*):(?<population>\\d+)![^@\\-!:>]*(?<attack>[AD])![^@\\-!:>]*->(?<soldier>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                double amount = Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("count"));
                System.out.printf("%s: %s - %.2f%n", matcher.group("customer"), matcher.group("product"), amount);
                totalSum += amount;
            }

            input = scanner.nextLine();

        }
        System.out.printf("Total income: %.2f", totalSum);
    }
}
