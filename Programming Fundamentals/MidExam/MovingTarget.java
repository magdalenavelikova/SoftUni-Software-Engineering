package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String commandLine = scanner.nextLine();

        while (!commandLine.contains("End")) {
            String command = commandLine.split(" ")[0];
            int index = Integer.parseInt(commandLine.split(" ")[1]);
            switch (command) {
                case "Shoot":
                    if (isValidIndex(targets, index)) {
                        int power = Integer.parseInt(commandLine.split(" ")[2]);
                        if ((targets.get(index) - power) > 0) {
                            targets.set(index, targets.get(index) - power);
                        } else {
                            targets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    if (isValidIndex(targets, index)) {
                        int value = Integer.parseInt(commandLine.split(" ")[2]);
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;

                case "Strike":
                    int radius = Integer.parseInt(commandLine.split(" ")[2]);
                    int counter = radius * 2 + 1;
                    if ((isValidIndex(targets, index + radius)) && (isValidIndex(targets, index - radius))) {
                        while (counter != 0) {
                            targets.remove(index - radius);
                            counter--;
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            commandLine = scanner.nextLine();
        }
        if (!targets.isEmpty()) {
            for (int i = 0; i < targets.size() - 1; i++) {
                System.out.print(targets.get(i) + "|");
            }
            System.out.print(targets.get(targets.size() - 1));
        }
    }

    public static boolean isValidIndex(List<Integer> targets, int index) {
        return (index >= 0 && index <= targets.size() - 1);
    }
}
