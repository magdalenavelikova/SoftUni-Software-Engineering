package textProcessingMoreExercise;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < rows; i++) {
            StringBuilder input = new StringBuilder(scanner.nextLine());
            int counter = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '@') {
                    counter++;
                }
            }
            if (counter == 1) {
                String name = input.substring(input.indexOf("@") + 1, input.indexOf("|"));
                String age = input.substring(input.indexOf("#") + 1, input.indexOf("*"));
                System.out.printf("%s is %s years old.%n", name, age);
            } else {
                while (counter > 0) {
                    String name = input.substring(input.indexOf("@") + 1, input.indexOf("|"));
                    String age = input.substring(input.indexOf("#") + 1, input.indexOf("*"));
                    input.delete(input.indexOf("@"), input.indexOf("*") + 1);
                    System.out.printf("%s is %s years old.%n", name, age);
                    counter--;

                }
            }

        }
    }
}
