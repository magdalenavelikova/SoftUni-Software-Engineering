package finalExam;

import java.util.Scanner;

public class Hogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder spell = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Abracadabra")) {
            String commands = input.split("\\s+")[0];
            switch (commands) {
                case "Abjuration":
                    spell = new StringBuilder(spell.toString().toUpperCase());
                    System.out.println(spell);
                    break;
                case "Necromancy":
                    spell = new StringBuilder(spell.toString().toLowerCase());
                    System.out.println(spell);
                    break;
                case "Illusion":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    char letter = input.split("\\s+")[2].charAt(0);
                    if (isValidIndex(spell, index)) {
                        spell.setCharAt(index, letter);
                        System.out.println("Done!");
                    } else {
                        System.out.println("The spell was too weak.");
                    }
                    break;
                case "Divination":
                    String firstSubstring = input.split("\\s+")[1];
                    String secondSubstring = input.split("\\s+")[2];
                    while (spell.toString().contains(firstSubstring)) {
                        spell = new StringBuilder(spell.toString().replace(firstSubstring, secondSubstring));
                    }
                    System.out.println(spell);
                    break;
                case "Alteration":
                    String substring = input.split("\\s+")[1];
                    if (spell.toString().contains(substring)) {
                        spell = new StringBuilder(spell.toString().replace(substring, ""));
                    }
                    System.out.println(spell);
                    break;
                default:
                    System.out.println("The spell did not work!");
                    break;
            }
            input = scanner.nextLine();
        }

    }

    private static boolean isValidIndex(StringBuilder spell, int index) {
        return index >= 0 && index < spell.length();
    }
}
