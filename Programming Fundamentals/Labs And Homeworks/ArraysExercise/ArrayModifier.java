package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbersArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String inputLine = scanner.nextLine();
        while (!inputLine.equals("end")) {
            if (!inputLine.equals("decrease")) {
                String command = inputLine.split(" ")[0];
                int firstIndex = Integer.parseInt(inputLine.split(" ")[1]);
                int secondIndex = Integer.parseInt(inputLine.split(" ")[2]);
                if (command.equals("swap")) {
                    int elementForSwap = numbersArray[firstIndex];
                    numbersArray[firstIndex] = numbersArray[secondIndex];
                    numbersArray[secondIndex] = elementForSwap;
                } else if (command.equals("multiply")) {
                    int multiply = numbersArray[firstIndex] * numbersArray[secondIndex];
                    numbersArray[firstIndex] = multiply;
                }
            } else {
                for (int i = 0; i < numbersArray.length; i++) {
                    int currentElement = numbersArray[i];
                    numbersArray[i] = currentElement - 1;
                }

            }
            inputLine = scanner.nextLine();
        }
        for (int i = 0; i < numbersArray.length - 1; i++) {
            System.out.print(numbersArray[i] + ", ");
        }
        System.out.print(numbersArray[numbersArray.length - 1]);
    }
}
