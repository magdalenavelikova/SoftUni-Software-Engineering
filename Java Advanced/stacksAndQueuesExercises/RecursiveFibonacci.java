package stacksAndQueuesExercises;


import java.util.Scanner;

public class RecursiveFibonacci {
    public static long memory[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        memory = new long[number + 1];
        System.out.println(getFibonacci(number));
    }

    private static long getFibonacci(int number) {
        if (number < 2) {
            return 1;
        }
        if (memory[number] != 0) {
            return memory[number];
        }
        memory[number] = (getFibonacci(number - 1) + getFibonacci(number - 2));
        return memory[number];
    }
}
