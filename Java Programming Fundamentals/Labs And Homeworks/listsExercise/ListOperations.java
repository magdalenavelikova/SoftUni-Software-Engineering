package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("End")) {
//•	Add {number} - add number at the end
//•	Insert {number} {index} - insert number at given index
//•	Remove {index} - remove that index
//•	Shift left {count} - first number becomes last 'count' times
//•	Shift right {count} - last number becomes first 'count' times
            if (commandLine.contains("Add")) {
                int numberToAdd = Integer.parseInt(commandLine.split(" ")[1]);
                numbersList.add(numberToAdd);
            } else if (commandLine.contains("Insert")) {
                int numberToAdd = Integer.parseInt(commandLine.split(" ")[1]);
                int position = Integer.parseInt(commandLine.split(" ")[2]);
                if (isValidIndex(numbersList.size(), position)) {
                    numbersList.add(position, numberToAdd);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (commandLine.contains("Remove")) {
                int position = Integer.parseInt(commandLine.split(" ")[1]);
                if (isValidIndex(numbersList.size(), position)) {
                    numbersList.remove(position);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (commandLine.contains("Shift left")) {
                int counter = Integer.parseInt(commandLine.split(" ")[2]);
                for (int i = 0; i < counter; i++) {
                    int firstNumber = numbersList.get(0);
                    numbersList.add(firstNumber);
                    numbersList.remove(0);
                }

            } else if (commandLine.contains("Shift right")) {
                int counter = Integer.parseInt(commandLine.split(" ")[2]);
                for (int i = 0; i < counter; i++) {
                    int lastNumber = numbersList.get(numbersList.size() - 1);
                    numbersList.add(0, lastNumber);
                    numbersList.remove(numbersList.size() - 1);
                }
            }
            commandLine= scanner.nextLine();
        }
        System.out.print(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
    public static boolean isValidIndex(int size, int position){
        return (position >= 0 && position < size);
    }
}
