package midExam23102022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOfCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> listOfCards = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .collect(Collectors.toList());
        int rows = Integer.parseInt(scanner.nextLine());
        String commandLine = "";
        for (int i = 1; i <= rows; i++) {
            commandLine = scanner.nextLine();
            String command = commandLine.split(", ")[0];
            switch (command) {
                case "Add":
                    String card = commandLine.split(", ")[1];
                    if (!listOfCards.contains(card)) {
                        listOfCards.add(card);
                        System.out.println("Card successfully added");
                    } else {
                        System.out.println("Card is already in the deck");
                    }
                    break;
                case "Remove":
                    String item = commandLine.split(", ")[1];
                    if (listOfCards.contains(item)) {
                        listOfCards.remove(item);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Card not found");
                    }
                    break;
                case "Remove At":
                    int index = Integer.parseInt(commandLine.split(", ")[1]);
                    if (isValidIndex(listOfCards, index)) {
                        listOfCards.remove(index);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Index out of range");
                    }

                    break;
                case "Insert":
                    int indexForInsert = Integer.parseInt(commandLine.split(", ")[1]);
                    String itemToAdd = commandLine.split(", ")[2];

                    if (isValidIndex(listOfCards, indexForInsert)) {
                        if (listOfCards.contains(itemToAdd)) {
                            System.out.println("Card is already added");
                        } else {
                            listOfCards.add(indexForInsert, itemToAdd);
                            System.out.println("Card successfully added");
                        }
                    } else {
                        System.out.println("Index out of range");
                    }


                    break;
            }

        }
        System.out.println(String.join(", ", listOfCards));
    }

    public static boolean isValidIndex(List<String> list, int index) {
        return (index >= 0 && index < list.size());

    }
}
