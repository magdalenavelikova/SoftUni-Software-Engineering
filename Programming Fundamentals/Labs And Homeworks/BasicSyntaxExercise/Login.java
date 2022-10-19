package basicSyntaxExercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        String password = "";
        for (int i = userName.length() - 1; i >= 0; i--) {
            password += userName.charAt(i);
        }
        int count = 0;
        String inputLine = scanner.nextLine();
        while (!inputLine.equals(password)) {
            count++;
            if (count==4){
                System.out.printf("User %s blocked!",userName);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            inputLine = scanner.nextLine();
        }
        if (count < 4) {
            System.out.printf("User %s logged in.", userName);
        }
    }
}
