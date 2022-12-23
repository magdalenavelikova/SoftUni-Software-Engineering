package functionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;


public class CountUppercaseWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Predicate<String> isFirstLetterUppercase = w -> Character.isUpperCase(w.charAt(0));
        List<String> wordsList = new ArrayList<>();

        Arrays.stream(words)
                .filter(isFirstLetterUppercase)
                .forEach(w -> wordsList.add(w));

        System.out.println(wordsList.size());
        wordsList.forEach(System.out::println);
    }
}
