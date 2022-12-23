package functionalProgrammingExercise;


import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Consumer<String> print = getPrint();

        for (String t : scanner.nextLine().split("\\s+")) {
            print.accept(t);
        }
    }

    private static Consumer<String> getPrint() {
        return System.out::println;
    }

}
