package associativeArraysLab;

import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split(" ");


        Map<String, Integer> countByWords = new LinkedHashMap<>();
        for (String word : inputLine) {
            String currentWord = word.toLowerCase();
            countByWords.putIfAbsent(currentWord, 0);
            int counter = countByWords.get(currentWord);
            countByWords.put(currentWord, counter + 1);
        }
        List<String> wordsList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : countByWords.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                wordsList.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", wordsList));


    }

}
