package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> itemsList = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .collect(Collectors.toList());
        String commandLine = scanner.nextLine();
        while (!commandLine.contains("Craft!")) {
            String command = commandLine.split(" - ")[0];
            String item = commandLine.split(" - ")[1];
            switch (command) {
                case "Collect":
                    if (!itemsList.contains(item)) {
                        itemsList.add(item);
                    }
                    break;
                case "Drop":
                    itemsList.removeIf(a -> a.equals(item));
                    break;
                case "Combine Items":
                    String oldItem = item.split(":")[0];
                    String newItem = item.split(":")[1];
                    if (itemsList.contains(oldItem)) {
                        int index = itemsList.indexOf(oldItem);
                        itemsList.add(index + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (itemsList.contains(item)) {
                        itemsList.removeIf(a -> a.equals(item));
                        itemsList.add(item);
                    }
                    break;

            }

            commandLine = scanner.nextLine();
        }
        for (int i = 0; i < itemsList.size()-1; i++) {
            System.out.print(itemsList.get(i)+", ");
        }
        System.out.print(itemsList.get(itemsList.size()-1));
    }
}
