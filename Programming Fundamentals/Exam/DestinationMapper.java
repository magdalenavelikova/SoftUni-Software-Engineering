package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "([=\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> validDestination = new ArrayList<>();
        while (matcher.find()) {
            validDestination.add(matcher.group("destination"));
        }
        int travelPoints = 0;
        for (String d : validDestination) {
            travelPoints += d.length();

        }
        System.out.print("Destinations: ");
        System.out.print(String.join(", ", validDestination));
        System.out.println();
        System.out.println("Travel Points: " + travelPoints);

    }
}
