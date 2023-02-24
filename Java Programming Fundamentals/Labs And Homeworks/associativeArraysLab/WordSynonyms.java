package associativeArraysLab;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> synonymsByWord = new LinkedHashMap<>();

        for (int i = 0; i < rows; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            synonymsByWord.putIfAbsent(word, new ArrayList<>());
            synonymsByWord.get(word).add(synonym);
        }
        for (Map.Entry<String, List<String>> entry : synonymsByWord.entrySet()) {
            System.out.printf("%s - ", entry.getKey());
            System.out.printf(String.join(", ", entry.getValue()));
            System.out.println();

        }


    }
}
