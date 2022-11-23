package exam;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String commandLine = scanner.nextLine();
        StringBuilder password = new StringBuilder(input);
        while (!commandLine.equals("Done")) {
            String command = commandLine.split("\\s+")[0];
            switch (command) {
                case "TakeOdd":
                    input = password.toString();
                    password=new StringBuilder();
                    for (int i = 1; i < input.length(); i += 2) {
                        password.append(input.charAt(i));
                    }
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandLine.split("\\s+")[1]);
                    int length = Integer.parseInt(commandLine.split("\\s+")[2]);
                    password.delete(index, index + length);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = commandLine.split("\\s+")[1];
                    String substitute = commandLine.split("\\s+")[2];
                    if (password.toString().contains(substring)) {
                        password = new StringBuilder(password.toString().replace(substring, substitute));
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }

                    break;


            }

            commandLine = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
