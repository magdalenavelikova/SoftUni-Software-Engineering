package exam;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String concealedMessage = scanner.nextLine();
        String commandLine = scanner.nextLine();
        StringBuilder actualMessage = new StringBuilder(concealedMessage);
        while (!commandLine.equals("Reveal")) {
            String command = commandLine.split(":\\|:")[0];
            String textToEdit = actualMessage.toString();
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandLine.split(":\\|:")[1]);
                    actualMessage = new StringBuilder(textToEdit.substring(0, index).concat(" ").concat(textToEdit.substring(index)));
                    System.out.println(actualMessage);
                    break;
                case "Reverse":
                    String substring = commandLine.split(":\\|:")[1];
                    if (textToEdit.contains(substring)) {
                        String reverse = new StringBuilder(substring).reverse().toString();
                        actualMessage.delete(actualMessage.indexOf(substring), actualMessage.indexOf(substring) + substring.length());
                        actualMessage.append(reverse);
                        System.out.println(actualMessage);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substringForReplacement = commandLine.split(":\\|:")[1];
                    String replacement = commandLine.split(":\\|:")[2];
                    while (textToEdit.contains(substringForReplacement)) {
                        textToEdit = textToEdit.replace(substringForReplacement, replacement);
                    }
                    actualMessage = new StringBuilder(textToEdit);
                    System.out.println(actualMessage);
                    break;
            }

            commandLine = scanner.nextLine();

        }
        System.out.println("You have a new text message: " + actualMessage);
    }
}
