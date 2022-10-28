package midExam;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int winningsCounter = 0;
        boolean isGameLost = false;
        String command = scanner.nextLine();
        while (!command.equals("End of battle")) {
            int distance = Integer.parseInt(command);
            if (energy >= distance) {
                energy -= distance;
                winningsCounter++;
            } else {
                isGameLost = true;
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", winningsCounter, energy);
                break;
            }
            if (winningsCounter % 3 == 0) {
                energy += winningsCounter;
            }
            command = scanner.nextLine();
        }
        if (!isGameLost) {
            System.out.printf("Won battles: %d. Energy left: %d", winningsCounter, energy);
        }
    }
}
