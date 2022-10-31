package associativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> licensePlateNumberByUsers = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String inputLine = scanner.nextLine();
            String command = inputLine.split("\\s+")[0];
            String user = inputLine.split("\\s+")[1];
            String currentUser = licensePlateNumberByUsers.get(user);
            switch (command) {
                case "register":
                    String licensePlateNumber = inputLine.split("\\s+")[2];
                    if (currentUser != null) {
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                    } else {
                        licensePlateNumberByUsers.put(user, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", user, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (currentUser == null) {
                        System.out.printf("ERROR: user %s not found%n", user);
                    } else {
                        licensePlateNumberByUsers.remove(user);
                        System.out.printf("%s unregistered successfully%n", user);
                    }
                    break;
            }

        }
        for (Map.Entry<String, String> entry : licensePlateNumberByUsers.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }
}
