package arraysExercise;

import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] treasureChest = inputLine.split("\\|");
        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Yohoho!")) {
            String[] lotItemsArr = commandLine.split(" ");
            String command = lotItemsArr[0];

            switch (command) {
                case "Loot":
                    for (int i = 1; i < lotItemsArr.length; i++) {
                        boolean isExist = false;
                        for (int j = 0; j < treasureChest.length; j++) {
                            if (lotItemsArr[i].equals(treasureChest[j])) {
                                isExist = true;
                            }
                        }
                        if (!isExist) {
                            String[] treasureChestAdd = new String[treasureChest.length + 1];
                            treasureChestAdd[0] = lotItemsArr[i];
                            for (int j = 1; j < treasureChestAdd.length; j++) {
                                treasureChestAdd[j] = treasureChest[j - 1];
                            }
                            treasureChest = treasureChestAdd;
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(lotItemsArr[1]);
                    if (index < treasureChest.length && index >= 0) {
                        String[] treasureChestDrop = new String[treasureChest.length];
                        treasureChestDrop[treasureChest.length - 1] = treasureChest[index];
                        for (int i = 0; i < index; i++) {
                            treasureChestDrop[i] = treasureChest[i];
                        }
                        for (int i = index; i < treasureChest.length - 1; i++) {
                            treasureChestDrop[i] = treasureChest[i + 1];
                        }
                        treasureChest = treasureChestDrop;
                    }
                    break;
                case "Steal":
                    int droppedLenght = Integer.parseInt(lotItemsArr[1]);
                    if (droppedLenght > treasureChest.length) {
                        droppedLenght = treasureChest.length;
                    }
                    String[] treasureChestSteal = new String[treasureChest.length - droppedLenght];
                    for (int i = treasureChest.length - droppedLenght; i < treasureChest.length; i++) {
                        if (i < treasureChest.length - 1) {
                            System.out.print(treasureChest[i] + ", ");
                        } else {
                            System.out.println(treasureChest[i]);
                        }
                    }
                    for (int i = 0; i < treasureChestSteal.length; i++) {
                        treasureChestSteal[i] = treasureChest[i];
                    }
                    treasureChest = treasureChestSteal;

                    break;
            }


            commandLine = scanner.nextLine();
        }
        if (treasureChest.length > 0) {
            int averageGain = 0;
            for (int i = 0; i < treasureChest.length; i++) {
                String element = treasureChest[i];
                averageGain += element.length();
            }
            double credits = averageGain / (treasureChest.length * 1.0);
            System.out.printf("Average treasure gain: %.2f pirate credits.", credits);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
