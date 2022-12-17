package setsAndMapsAdvancedExcersise;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Character.isDigit;

public class HandsOfCards {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> deck = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String name = input.split(":\\s+")[0];
            List<String> cards = Arrays.stream(input.split(":\\s+")[1].trim().split(", "))
                    .collect(Collectors.toList());

            deck.putIfAbsent(name, new HashSet<>());
            deck.get(name).addAll(cards);
            
/*            for (String card : cards) {
                deck.get(name).add(card);
            }*/
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : deck.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            int sum = getPower(entry);
            System.out.print(sum);
            System.out.println();
        }


    }

    private static int getPower(Map.Entry<String, Set<String>> entry) {
        int sum = 0;
        for (String s : entry.getValue()) {
            String type = s.substring(s.length() - 1);
            String currentCard = s.substring(0, s.length() - 1);

            int multiplier = getMultiplier(type);

            if (isDigit(currentCard.charAt(0))) {
                int card = Integer.parseInt(currentCard);
                sum += card * multiplier;
            } else {
                switch (currentCard) {
                    case "J":
                        sum += 11 * multiplier;
                        break;
                    case "Q":
                        sum += 12 * multiplier;
                        break;
                    case "K":
                        sum += 13 * multiplier;
                        break;
                    case "A":
                        sum += 14 * multiplier;
                        break;
                }
            }

        }
        return sum;
    }

    private static int getMultiplier(String type) {
        int multiplier = 0;
        switch (type) {
            case "S":
                multiplier = 4;
                break;
            case "H":
                multiplier = 3;
                break;
            case "D":
                multiplier = 2;
                break;
            case "C":
                multiplier = 1;
                break;
        }
        return multiplier;
    }
}
