package whileLabAndExercise;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        String input= scanner.nextLine();
        while (!input.equals(password)){
            input= scanner.nextLine();
        }
        System.out.println("Welcome "+username+"!");
    }
}
