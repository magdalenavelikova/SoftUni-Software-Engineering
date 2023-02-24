package regularExpressionsExercise;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> validFurniture = new ArrayList<>();
        double amount = 0;
        while (!input.equals("Purchase")) {
            String regex = ">>(?<name>\\w+ ?\\w+)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String furniture = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                validFurniture.add(furniture);
                amount += price * quantity;

            }

            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String s : validFurniture) {
            System.out.println(s);
        }

        System.out.printf("Total money spend: %.2f", amount);
    }
}
