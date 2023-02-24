package listsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> guestsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String commandLine = scanner.nextLine();
            List<String> commands = Arrays.stream(commandLine.split(" ")).collect(Collectors.toList());
            String name = commands.get(0);
            String condition = commands.get(2);
            if (condition.equals("going!")) {
                if (guestsList.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guestsList.add(name);
                }
            } else if (condition.equals("not")) {
                if (guestsList.contains(name)) {
                    guestsList.removeIf(e -> e.equals(name));
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }

        if (!guestsList.isEmpty()) {
            for (String item : guestsList) {
                System.out.println(item);
            }
        }
    }
}
