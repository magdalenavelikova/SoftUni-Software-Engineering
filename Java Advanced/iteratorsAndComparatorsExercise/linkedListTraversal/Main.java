package iteratorsAndComparatorsExercise.linkedListTraversal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        LinkedList linkedList = new LinkedList();

        while (--rows >= 0) {
            String[] commandLine = scanner.nextLine().split("\\s+");
            String command = commandLine[0];
            int element = Integer.parseInt(commandLine[1]);
            if (command.equals("Add")) {
                linkedList.add(element);
            } else if (command.equals("Remove")) {
                linkedList.remove(element);

            }

        }
        System.out.println(linkedList.getSize());
        for (Node node : linkedList) {
            System.out.print(node);
        }
    }
}
