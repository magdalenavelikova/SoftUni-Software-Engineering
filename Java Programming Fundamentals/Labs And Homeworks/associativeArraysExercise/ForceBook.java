package associativeArraysExercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> forceBook = new LinkedHashMap<>();
        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String[] command = input.split("\\s+\\|\\s+");
                String side = command[0];
                String userName = command[1];
                forceBook.putIfAbsent(side, new ArrayList<>());


                if (!isUserExist(forceBook, userName)) {
                    forceBook.get(side).add(userName);
                }

            } else if (input.contains("->")) {
                String[] command = input.split("\\s+->\\s+");
                String side = command[1];
                String userName = command[0];
                forceBook.forEach((k, v) -> v.remove(userName));
                forceBook.putIfAbsent(side, new ArrayList<>());
                forceBook.get(side).add(userName);
                System.out.printf("%s joins the %s side!%n", userName, side);

            }

            input = scanner.nextLine();
        }


        forceBook.forEach((k, v) -> {
            if (v.size() != 0) {
                System.out.println("Side: " + k + ", Members: " + v.size());
                for (String s : v) {
                    System.out.printf("! %s%n", s);
                }

            }
        });

    }

    public static boolean isUserExist(Map<String, List<String>> users, String user) {

        for (Map.Entry<String, List<String>> entry : users.entrySet()) {
            for (String s : entry.getValue()) {
                if (s.equals(user)) {
                    return true;
                }
            }


        }
        return false;
    }
}
