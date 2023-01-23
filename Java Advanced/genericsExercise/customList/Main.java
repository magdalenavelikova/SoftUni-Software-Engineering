package genericsExercise.customList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> customList = new CustomList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commandsPart = input.split("\\s+");
            String nameCommand = commandsPart[0];

            switch (nameCommand) {
                case "Add":
                    String element = commandsPart[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(commandsPart[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String searchElement = commandsPart[1];
                    System.out.println(customList.contains(searchElement));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(commandsPart[1]);
                    int index2 = Integer.parseInt(commandsPart[2]);
                    customList.swap(index1, index2);
                    break;
                case "Greater":
                    String elementToCompare = commandsPart[1];
                    System.out.println(customList.countGreaterThan(elementToCompare));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.forEach(System.out::println);
//                    for (String list: customList ) {
//                        System.out.println(list);
//                    }
                    break;
                case "Sort":
                   Sorter.sort(customList);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown command!");


            }


            input = scanner.nextLine();
        }

    }
}
