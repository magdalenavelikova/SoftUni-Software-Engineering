package multidimensionalArraysExercise;

import java.util.Scanner;

public class TheHeiganDance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double hsPoints = 3000000.0;
        int playerPoints = 18500;

        int startPlRow = 7;
        int startPlCol = 7;

        String lastSpell = "";
        boolean activeCloud = false;

        double damage = Double.parseDouble(scanner.nextLine());

        while (playerPoints > 0 && hsPoints > 0) {
            hsPoints -= damage;

            if (activeCloud) {
                playerPoints -= 3500;
                activeCloud = false;

                if (playerPoints < 0) {
                    break;
                }
            }

            if (hsPoints < 0) {
                break;
            }

            String[] input = scanner.nextLine().split("\\s+");

            String spell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);

            boolean[][] chamber = new boolean[15][15];

            fillDamageHSChamber(row, col, chamber);

            if (chamber[startPlRow][startPlCol]) {

                if (isRowValid(chamber, startPlRow - 1) && !chamber[startPlRow - 1][startPlCol]) {
                    startPlRow--; // move up
                } else if (isColValid(chamber, startPlCol + 1) && !chamber[startPlRow][startPlCol + 1]) {
                    startPlCol++; // move right
                } else if (isRowValid(chamber, startPlRow + 1) && !chamber[startPlRow + 1][startPlCol]) {
                    startPlRow++; // move down
                } else if (isColValid(chamber, startPlCol - 1) && !chamber[startPlRow][startPlCol - 1]) {
                    startPlCol--; // move left
                }

                if (chamber[startPlRow][startPlCol]) {
                    switch (spell) {
                        case "Cloud":
                            playerPoints -= 3500;
                            activeCloud = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerPoints -= 6000;
                            lastSpell = spell;
                            break;

                    }
                }
            }
        }

        if (hsPoints > 0) {
            System.out.printf("Heigan: %.2f%n", hsPoints);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerPoints > 0) {
            System.out.printf("Player: %d%n", playerPoints);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }

        System.out.println("Final position: " + startPlRow + ", " + startPlCol);
    }

    private static void fillDamageHSChamber(int row, int col, boolean[][] chamber) {

        for (int i = row - 1; i <= row + 1; i++) {

            if (i >= 0 && i < chamber.length) {

                for (int j = col - 1; j <= col + 1; j++) {
                    if (j >= 0 && j < chamber[row].length) {
                        chamber[i][j] = true;
                    }
                }
            }
        }
    }

    private static boolean isRowValid(boolean[][] hsChamber, int startPlRow) {
        return startPlRow >= 0 && startPlRow < hsChamber[startPlRow].length;
    }

    private static boolean isColValid(boolean[][] hsChamber, int startPlCol) {
        return startPlCol >= 0 && startPlCol < hsChamber.length;
    }

}
