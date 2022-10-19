package dataTypesAndVariablesExercise;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//•	On the first line, you will receive n – the number of lines, which will follow
//•	On the next n lines – you receive quantities of water, which you have to pour into the tank
        int n = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        boolean isEnoughCapacity = true;

        for (int i = 0; i < n; i++) {
            int quantities = Integer.parseInt(scanner.nextLine());
            if (capacity >= quantities) {
                capacity -= quantities;
                isEnoughCapacity = true;
            } else {
                isEnoughCapacity = false;

            }
            if (!isEnoughCapacity) {
                System.out.println("Insufficient capacity!");

            }
        }
        System.out.println(255 - capacity);

    }
}
