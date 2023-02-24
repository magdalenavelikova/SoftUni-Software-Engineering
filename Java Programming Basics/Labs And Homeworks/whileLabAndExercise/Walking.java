package whileLabAndExercise;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int steps = 0;
        int target = 0;
        int goal=10000;
        while (target < goal) {
            String command = scanner.nextLine();
            if (command.equals("Going home")) {
                steps = Integer.parseInt(scanner.nextLine());
                target += steps;
                break;
            } else {
                steps = Integer.parseInt(command);
                target += steps;
            }


        }
        if (target < goal) {
            System.out.printf("%d more steps to reach goal.",goal-target);
        } else {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", target-goal);
        }
    }
}
