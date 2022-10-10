package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] targets = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String commandLine = scanner.nextLine();
        int shotCounter = 0;
        while (!commandLine.equals("End")) {
            int index = Integer.parseInt(commandLine);
            if (isValidIndex(targets, index)) {
                if (targets[index] != -1) {
                    int currentTarget = targets[index];
                    targets[index] = -1;
                    shotCounter++;

                    for (int i = 0; i < targets.length; i++) {
                        if (targets[i] > currentTarget && targets[i] != -1) {
                            targets[i] -= currentTarget;
                        } else if (targets[i] <= currentTarget && targets[i] != -1) {
                            targets[i] += currentTarget;
                        }
                    }
                }
            }
            commandLine = scanner.nextLine();

        }
        System.out.printf("Shot targets: %d -> ", shotCounter);
        for (int item : targets) {
            System.out.print(item + " ");
        }
    }

    public static boolean isValidIndex(int[] array, int index) {
        return (index >= 0 && index <= array.length - 1);
    }
}
