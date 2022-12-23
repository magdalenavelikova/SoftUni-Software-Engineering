package functionalProgrammingExercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TPRF {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        Set<String> commands = new HashSet<>();

        while (!command.equals("Print")) {

            if (command.split(";")[0].equals("Add filter")) {
                commands.add(command.split(";")[1] + ";" + command.split(";")[2]);
            } else {
                commands.remove(command.split(";")[1] + ";" + command.split(";")[2]);
            }
            command = scanner.nextLine();
        }

        for (String element : commands) {
            Predicate<String> isConditionTrue = getListOfGuest(element);
            guestList.removeIf(isConditionTrue);

        }

        guestList.stream().forEach(guest -> System.out.print(guest + " "));

    }

    private static Predicate<String> getListOfGuest(String command) {
        String criteria = command.split(";")[1];
        switch (command.split(";")[0]) {
            case "Starts with":
                return s -> s.startsWith(criteria);
            case "Length":
                return s -> s.length() == Integer.parseInt(criteria);
            case "Ends with":
                return s -> s.endsWith(criteria);
            case "Contains":
                return s -> s.contains(criteria);
            default:
                throw new IllegalArgumentException("Unknown condition " + command);
        }

    }
}
