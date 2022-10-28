package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String commandline = scanner.nextLine();
//        •	Delete {element} - delete all elements in the array, which are equal to the given element
//•	Insert {element} {position}

        while (!commandline.equals("end")) {
            String command = commandline.split(" ")[0];
            int element = Integer.parseInt(commandline.split(" ")[1]);
            if (command.equals("Delete")) {
                numbersList.removeAll(Arrays.asList(element));
            } else if (command.equals("Insert")) {
                int index = Integer.parseInt(commandline.split(" ")[2]);
                numbersList.add(index, element);
            }

            commandline = scanner.nextLine();
        }
        System.out.print(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
