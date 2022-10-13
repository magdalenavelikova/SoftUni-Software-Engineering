package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList = Arrays.stream(scanner.nextLine()
                        .split("!"))
                .collect(Collectors.toList());
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Go Shopping!")) {
            String command = commandLine.split(" ")[0];
            String item = commandLine.split(" ")[1];
            switch (command) {
                case "Urgent":
                    if (!shoppingList.contains(item)) {
                        shoppingList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    shoppingList.remove(item);
                    break;
                case "Correct":
                    String newItem = commandLine.split(" ")[2];
                    if (shoppingList.contains(item)) {
                        for (int i = 0; i < shoppingList.size(); i++) {
                            if (shoppingList.get(i).equals(item)) {
                                shoppingList.set(i, newItem);
                            }
                        }
                    }
                    break;
                case "Rearrange":

                    if (shoppingList.contains(item)) {
                        for (int i = 0; i < shoppingList.size(); i++) {
                            if (shoppingList.get(i).equals(item)) {
                                String currentItem = shoppingList.get(i);
                                shoppingList.remove(i);
                                shoppingList.add(currentItem);
                            }

                        }
                    }
                    break;
            }


            commandLine = scanner.nextLine();
        }
        System.out.println(String.join(", ",shoppingList));
    }
}
