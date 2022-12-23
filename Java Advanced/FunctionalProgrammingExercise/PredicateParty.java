package functionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Party!")) {

            Predicate<String> isConditionTrue = getListOfGuest(command);
            String action = command.split("\\s+")[0];

            if (action.equals("Remove")) {
                List<String> listToRemove = guestList.stream().filter(isConditionTrue).collect(Collectors.toList());
                guestList.removeAll(listToRemove);

            } else if (action.equals("Double")) {
                List<String> listToAdd = guestList.stream().filter(isConditionTrue).collect(Collectors.toList());
                guestList.addAll(listToAdd);
            }
            command = scanner.nextLine();
        }
        if (guestList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guestList);
            for (int i = 0; i < guestList.size(); i++) {
                if (i < guestList.size() - 1) {
                    System.out.print(guestList.get(i) + ", ");
                } else {
                    System.out.print(guestList.get(i) + " are going to the party!");
                }

            }

        }

    }

    private static Predicate<String> getListOfGuest(String command) {
        String criteria = command.split("\\s+")[2];
        switch (command.split("\\s+")[1]) {
            case "StartsWith":
                return s -> s.startsWith(criteria);
            case "Length":
                return s -> s.length() == Integer.parseInt(criteria);
            case "EndsWith":
                return s -> s.endsWith(criteria);
            default:
                throw new IllegalArgumentException("Unknown condition " + command);
        }

    }
}
