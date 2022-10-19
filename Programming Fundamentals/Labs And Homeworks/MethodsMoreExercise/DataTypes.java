package methodsMoreExercise;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String input = scanner.nextLine();
        printResult(type, input);
    }

    private static void printResult(String type, String input) {

        switch (type) {
            case "int":
                int number = Integer.parseInt(input);
                System.out.println(number * 2);
                break;
            case "real":
                double num = Double.parseDouble(input);
                System.out.printf("%.2f", num * 1.5);
                break;
            case "string":
                System.out.printf("$%s$", input);
                break;
        }
    }
}
