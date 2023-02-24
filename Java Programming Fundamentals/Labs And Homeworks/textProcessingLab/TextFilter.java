package textProcessingLab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(",\\s+");
        String text = scanner.nextLine();
        for (String item : bannedWords) {
            int index = text.indexOf(item);
            StringBuilder asterisks = new StringBuilder();
            for (int i = 0; i < item.length(); i++) {
                asterisks.append("*");
            }
            while (index != -1) {
                text = text.replace(item, asterisks);
                index = text.indexOf(item);
            }
        }

        System.out.println(text);
    }
}
