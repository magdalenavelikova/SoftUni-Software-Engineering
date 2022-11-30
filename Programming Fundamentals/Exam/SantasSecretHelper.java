package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());

        String message = scanner.nextLine();
        List<String> childrenList = new ArrayList<>();

        while (!message.equals("end")) {
            String encryptedMessage = getEncryptedMessage(key, message);
            String regex = "@(?<name>[A-Za-z]+)(.[^@\\-!:>]*)(?<behavior>![GN]?!)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(encryptedMessage);
            if (matcher.find()) {
                if (matcher.group("behavior").equals("!G!")) {
                    childrenList.add(matcher.group("name"));
                }
            }
            message = scanner.nextLine();
        }
        System.out.println(String.join("\n",childrenList));
    }

    private static String getEncryptedMessage(int key, String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int currentChar = message.charAt(i) - key;
            encryptedMessage.append((char) (currentChar));
        }
        return encryptedMessage.toString();
    }
}
