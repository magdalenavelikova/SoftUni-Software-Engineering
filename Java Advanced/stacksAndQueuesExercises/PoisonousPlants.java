package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plants = Integer.parseInt(scanner.nextLine());
        int[] pesticideArr = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> pesticideStack = new ArrayDeque<>();
        ArrayDeque<Integer> alivePlantsStack = new ArrayDeque<>();
        for (int entry : pesticideArr) {
            pesticideStack.push(entry);
        }
        int daysWithDeath = 0;
        boolean isThereDeathPlants = true;
        while (isThereDeathPlants) {
            while (pesticideStack.size() != 1) {
                int plantOneWithPesticide = pesticideStack.pop();
                int plantTwoWithPesticide = pesticideStack.peek();

                if (plantOneWithPesticide <= plantTwoWithPesticide) {
                    alivePlantsStack.push(plantOneWithPesticide);
                }
            }

            for (Integer entry : alivePlantsStack) {
                pesticideStack.push(alivePlantsStack.pop());
            }

            if (pesticideStack.size() != plants) {
                isThereDeathPlants = true;
            } else {
                isThereDeathPlants = false;
            }
            plants = pesticideStack.size();

            if (isThereDeathPlants) {
                daysWithDeath++;
            }
        }

        System.out.println(daysWithDeath);

    }
}
