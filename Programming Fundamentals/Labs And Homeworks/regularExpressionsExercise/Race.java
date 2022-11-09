package regularExpressionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> distanceByName = new TreeMap<>();
        String[] names = scanner.nextLine().split(", ");
        for (String name : names) {
            distanceByName.put(name, 0);
        }
        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            String regexForDigits = "\\d";
            String regexForLetter = "[^\\d^\\W]";
            Pattern pattern = Pattern.compile(regexForDigits);
            Matcher matcherForDigits = pattern.matcher(input);
            Pattern patternForLetter = Pattern.compile(regexForLetter);
            Matcher matcherForLetters = patternForLetter.matcher(input);

            int distance = 0;
            StringBuilder name = new StringBuilder();
            while (matcherForLetters.find()) {
                name.append(matcherForLetters.group());
            }
            while (matcherForDigits.find()) {
                distance += Integer.parseInt(matcherForDigits.group());
            }
            if (distanceByName.containsKey(name.toString())) {
                int currentDistance = distanceByName.get(name.toString());
                distanceByName.put(name.toString(), currentDistance + distance);
            }
            input = scanner.nextLine();
        }
        Map<Integer, String> nameByDistance = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<String, Integer> entry : distanceByName.entrySet()) {
            nameByDistance.put(entry.getValue(), entry.getKey());
        }
        List<String> winner = (nameByDistance.entrySet().stream()
                .limit(3)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList()));

        System.out.printf("1st place: %s%n", winner.get(0));
        System.out.printf("2nd place: %s%n", winner.get(1));
        System.out.printf("3rd place: %s%n", winner.get(2));
    }
}
