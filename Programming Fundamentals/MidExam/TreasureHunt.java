package MidExam;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> treasureChests = Arrays.stream(scanner.nextLine()
                        .split("\\|"))
                .collect(Collectors.toList());
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Yohoho!")) {
            String command = commandLine.split(" ")[0];
            switch (command) {
                case "Loot":
                    String[] arrayOfItem = commandLine.split(" ");
                    for (int i = 1; i < arrayOfItem.length; i++) {
                        String item = arrayOfItem[i];
                        if (!treasureChests.contains(item)) {
                            treasureChests.add(0, item);
                        }

                    }

                    break;
                case "Drop":
                    int index = Integer.parseInt(commandLine.split(" ")[1]);
                    if (isValidIndex(treasureChests, index)) {
                        String currentLoot = treasureChests.get(index);
                        treasureChests.remove(index);
                        treasureChests.add(currentLoot);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(commandLine.split(" ")[1]);
                    int startIndex = treasureChests.size() - count;
                    if (startIndex < 0) {
                        startIndex = 0;
                        count = treasureChests.size();
                    }
                    if (isValidIndex(treasureChests, startIndex)) {
                        for (int i = 1; i <= count; i++) {
                            if (i < count) {
                                System.out.print(treasureChests.get(startIndex) + ", ");
                            } else {
                                System.out.println(treasureChests.get(startIndex));
                            }
                            treasureChests.remove(startIndex);
                        }
                    }
                    break;
            }

            commandLine = scanner.nextLine();
        }
        if (treasureChests.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double treasureGain = 0;
            for (String item : treasureChests) {
                treasureGain += item.length();
            }
            System.out.printf("Average treasure gain: %.2f pirate credits.", treasureGain / treasureChests.size());
        }

    }

    public static boolean isValidIndex(List<String> list, int index) {
        return (index >= 0 && index < list.size());

    }
}
