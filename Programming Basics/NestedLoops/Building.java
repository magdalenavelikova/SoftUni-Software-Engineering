package NestedLoops;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int floors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());
        boolean isLarge = false;
        if (floors == 1) {
            isLarge = true;
        }

        for (int i = floors; i >= 1; i--) {
            if (i == floors) {
                isLarge = true;
            }else {
                isLarge = false;

            }

            for (int j = 0; j < rooms; j++) {
                if (isLarge) {
                    System.out.printf("L%d%d ", i, j);
                } else {
                    if (i % 2 == 0) {
                        System.out.printf("O%d%d ", i, j);
                    } else {
                        System.out.printf("A%d%d ", i, j);
                    }
                }
            }
            System.out.printf("%n");

        }
    }
}
