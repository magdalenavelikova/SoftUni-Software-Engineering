package archive;

import java.util.Scanner;

public class Censorship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String sentence = scanner.nextLine();

        while (sentence.contains(word)) {
            sentence = sentence.replace(word, "*".repeat(word.length()));
        }
        System.out.println(sentence);
    }
}
