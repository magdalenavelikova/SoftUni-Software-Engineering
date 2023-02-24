package archive;

import java.util.Scanner;

public class Hideout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String command = scanner.nextLine();
        String character = (command.split("\\s+")[0]);
        int counter = Integer.parseInt(command.split("\\s+")[1]);
        String sentence = (character.repeat(counter));
        while (!input.contains(sentence)) {
            command = scanner.nextLine();
            character = (command.split("\\s+")[0]);
            counter = Integer.parseInt(command.split("\\s+")[1]);
            sentence = (character.repeat(counter));
        }
        int index = input.indexOf(sentence);
        int currentCounter = 0;
        for (int i = index; i < input.length(); i++) {
            if (String.valueOf(input.charAt(i)).equals(character)) {
                currentCounter++;
            } else {
                break;
            }
        }
        System.out.printf("Hideout found at index %d and it is with size %d!", index, currentCounter);
    }
}
