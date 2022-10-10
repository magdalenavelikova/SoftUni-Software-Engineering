package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("end")) {
            String command = commandLine.split(" ")[0];
            switch (command) {

                case "swap":
                    int firstIndex = Integer.parseInt((commandLine.split(" ")[1]));
                    int secondIndex = Integer.parseInt((commandLine.split(" ")[2]));
                    swap(numbers, firstIndex, secondIndex);
                    break;
                case "multiply":
                    int first = Integer.parseInt((commandLine.split(" ")[1]));
                    int second = Integer.parseInt((commandLine.split(" ")[2]));
                    multiply(numbers, first, second);
                    break;
                case "decrease":
                    decrease(numbers);
                    break;
            }

            commandLine = scanner.nextLine();
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.print(numbers[numbers.length - 1]);
    }

    public static void decrease(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] -= 1;
        }
    }

    public static void multiply(int[] array, int firstIndex, int secondIndex) {
        array[firstIndex] = array[firstIndex] * array[secondIndex];
    }

    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int firstElement = array[firstIndex];
        int secondElement = array[secondIndex];

        array[firstIndex] = secondElement;
        array[secondIndex] = firstElement;
    }
}
