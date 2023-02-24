package regularExpressionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int messageCount = Integer.parseInt(scanner.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        for (int i = 0; i < messageCount; i++) {
            String encryptedMessage = scanner.nextLine();
            String decryptedMessage = getDecryptedMessage(encryptedMessage);
//         planet name, population, attack type ('A', as an attack or 'D', as destruction), and soldier count.

            String regex = "@(?<planet>[A-z]+)([^@\\-!:>]*):(?<population>\\d+)![^@\\-!:>]*(?<attack>[AD])![^@\\-!:>]*->(?<soldier>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);
            while (matcher.find()) {

                if (matcher.group("attack").equals("A")) {
                    attackedPlanets.add(matcher.group("planet"));
                } else {
                    destroyedPlanets.add(matcher.group("planet"));
                }

            }


        }
        System.out.println("Attacked planets: " + attackedPlanets.size());
        Collections.sort(attackedPlanets);
        attackedPlanets.forEach(planet -> System.out.println("-> " + planet));
        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        Collections.sort(destroyedPlanets);
        destroyedPlanets.forEach(planet -> System.out.println("-> " + planet));

    }


    private static String getDecryptedMessage(String encryptedMessage) {
        int countSpecialLetters = getCounterForSpecialLetter(encryptedMessage);
        StringBuilder decryptedMessage = new StringBuilder();
        for (char c : encryptedMessage.toCharArray()) {
            char decryptedLetter = (char) (c - countSpecialLetters);
            decryptedMessage.append(decryptedLetter);
        }

        return decryptedMessage.toString();
    }

    private static int getCounterForSpecialLetter(String encryptedMassage) {
        int count = 0;
        for (char letter : encryptedMassage.toLowerCase().toCharArray()) {
            switch (letter) {
                case 's':
                case 't':
                case 'a':
                case 'r':
                    count++;
                    break;
            }
        }
        return count;
    }
}
