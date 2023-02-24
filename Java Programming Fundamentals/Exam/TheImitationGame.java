package exam;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Decode")) {

            String command = input.split("\\|")[0];
            switch (command) {
                case "ChangeAll":
                    String substring = input.split("\\|")[1];
                    String replacement = input.split("\\|")[2];
                    String decryptedMessage=message.toString().replace(substring,replacement);
                    message = new StringBuilder(decryptedMessage);
                    break;
                case "Move":
                    int numberOfLetters = Integer.parseInt(input.split("\\|")[1]);
                    String newString = (message.substring(numberOfLetters)).concat(message.substring(0, numberOfLetters));
                    message = new StringBuilder(newString);
                    break;

                case "Insert":
                    int index = Integer.parseInt(input.split("\\|")[1]);
                    String value = input.split("\\|")[2];
                    String String = message.substring(0, index).concat(value).concat(message.substring(index));
                    message = new StringBuilder(String);
                    break;
            }
            input = scanner.nextLine();

        }
        System.out.println("The decrypted message is: "+message);
    }
}
