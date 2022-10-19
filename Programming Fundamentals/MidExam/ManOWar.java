package midExam;

import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] pirateShip = Arrays
                .stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] warShip = Arrays
                .stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maximumHealth = Integer.parseInt(scanner.nextLine());
        String commandLine = scanner.nextLine();
        boolean isEnd = false;
        while (!commandLine.equals("Retire") && !(isEnd)) {
            String command = commandLine.split(" ")[0];
            if (command.equals("Status")) {
                int counter = 0;
                for (int i = 0; i < pirateShip.length; i++) {
                    if (pirateShip[i] < maximumHealth * 0.2) {
                        counter++;
                    }
                }
                System.out.println(counter + " sections need repair.");
            } else {
                int index = Integer.parseInt(commandLine.split(" ")[1]);
                switch (command) {
                    case "Fire":
                        int damage = Integer.parseInt(commandLine.split(" ")[2]);
                        if (isValidIndex(warShip, index)) {
                            warShip[index] -= damage;
                            if (warShip[index] <= 0) {
                                System.out.println("You won! The enemy ship has sunken.");
                                isEnd = true;
                                break;
                            }
                        }
                        break;
                    case "Defend":
                        int endIndex = Integer.parseInt(commandLine.split(" ")[2]);
                        int damageDefend = Integer.parseInt(commandLine.split(" ")[3]);
                        if (isValidIndex(pirateShip, index) && isValidIndex(pirateShip, endIndex)) {
                            for (int i = index; i <= endIndex; i++) {
                                pirateShip[i] -= damageDefend;
                                if (pirateShip[i] <= 0) {
                                    System.out.println("You lost! The pirate ship has sunken.");
                                    isEnd = true;
                                    break;
                                }
                            }

                        }
                        break;
                    case "Repair":
                        int health = Integer.parseInt(commandLine.split(" ")[2]);
                        if (isValidIndex(pirateShip, index)) {
                            if ((pirateShip[index] + health) <= maximumHealth) {
                                pirateShip[index] += health;
                            } else {
                                pirateShip[index] = maximumHealth;

                            }

                        }


                        break;

                }
            }
            if (!(isEnd)) {
                commandLine = scanner.nextLine();
            }
        }
        if (!isEnd) {
            System.out.printf("Pirate ship status: %d%n", getStatus(pirateShip));
            System.out.printf("Warship status: %d%n", getStatus(warShip));
        }
    }

    public static int getStatus(int[] array) {
        int status = 0;
        for (int i = 0; i < array.length; i++) {
            status += array[i];
        }
        return status;
    }

    public static boolean isValidIndex(int[] array, int index) {
        return (index >= 0 && index < array.length);
    }
}
