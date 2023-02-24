package textProcessingMoreExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Character> lettersByMorseCode = new HashMap<>();
        createMorseCodeMap(lettersByMorseCode);
        String[] code = scanner.nextLine().split("\\|");
        StringBuilder decodedMassage = new StringBuilder();
        for (String s : code) {
            String[] letter = s.split(" ");
            for (int i = 0; i < letter.length; i++) {
                Character currentLetter = getLetter(letter[i], lettersByMorseCode);
                if (currentLetter != null) {
                    decodedMassage.append(currentLetter);
                }
            }

            decodedMassage.append(" ");

        }


        System.out.println(decodedMassage);

    }

    public static Character getLetter(String morseCode, Map<String, Character> lettersByMorseCode) {
        return lettersByMorseCode.get(morseCode);
    }

    public static void createMorseCodeMap(Map<String, Character> lettersByMorseCode) {
        lettersByMorseCode.put(".-", 'A');
        lettersByMorseCode.put("-...", 'B');
        lettersByMorseCode.put("-.-.", 'C');
        lettersByMorseCode.put("-..", 'D');
        lettersByMorseCode.put(".", 'E');
        lettersByMorseCode.put("..-.", 'F');
        lettersByMorseCode.put("--.", 'G');
        lettersByMorseCode.put("....", 'H');
        lettersByMorseCode.put("..", 'I');
        lettersByMorseCode.put(".---", 'J');
        lettersByMorseCode.put("-.-", 'K');
        lettersByMorseCode.put(".-..", 'L');
        lettersByMorseCode.put("--", 'M');
        lettersByMorseCode.put("-.", 'N');
        lettersByMorseCode.put("---", 'O');
        lettersByMorseCode.put(".--.", 'P');
        lettersByMorseCode.put("--.-", 'Q');
        lettersByMorseCode.put(".-.", 'R');
        lettersByMorseCode.put("...", 'S');
        lettersByMorseCode.put("-", 'T');
        lettersByMorseCode.put("..-", 'U');
        lettersByMorseCode.put("...-", 'V');
        lettersByMorseCode.put(".--", 'W');
        lettersByMorseCode.put("-..-", 'X');
        lettersByMorseCode.put("-.--", 'Y');
        lettersByMorseCode.put("--..", 'Z');

    }
}
