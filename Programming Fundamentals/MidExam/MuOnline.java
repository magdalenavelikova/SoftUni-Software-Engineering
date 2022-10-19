package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> rooms = Arrays.stream(scanner.nextLine()
                        .split("\\|"))
                .collect(Collectors.toList());
        int bitcoin = 0;
        int health = 100;
        boolean isKilled = false;
        for (int i = 0; i < rooms.size(); i++) {
            String command = rooms.get(i).split(" ")[0];
            int number = Integer.parseInt(rooms.get(i).split(" ")[1]);
            switch (command) {
                case "potion":
                    if (number + health > 100) {
                        number = 100 - health;
                        health = 100;
                    } else {
                        health += number;
                    }
                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.%n", health);

                    break;
                case "chest":
                    bitcoin += number;
                    System.out.printf("You found %d bitcoins.%n", number);
                    break;
                default:

                    health -= number;
                    if (health <= 0) {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d", i + 1);
                        i = rooms.size() - 1;
                        isKilled = true;
                        break;
                    } else {
                        System.out.printf("You slayed %s.%n", command);
                    }
            }
        }
        if (!isKilled) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoin);
            System.out.printf("Health: %d%n", health);
        }


    }
}
