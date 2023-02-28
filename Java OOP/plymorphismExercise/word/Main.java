package plymorphismExercise.word;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        CommandInterface commandInterface = Initialization.buildCommandInterface(text);

        String inputLine = scanner.nextLine();

        while(!inputLine.equals("exit")) {
            commandInterface.handleInput(inputLine);
            inputLine = scanner.nextLine();
        }

        System.out.println(text);
    }
}
