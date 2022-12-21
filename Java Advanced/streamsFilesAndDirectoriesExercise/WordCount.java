package streamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class WordCount {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader("C:\\IdeaProjects\\Java Advanced\\Resources\\Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
        Scanner scanner = new Scanner(bf);
        PrintWriter printWriter=new PrintWriter("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/result.txt");
        Map<String, Integer> counterByWords = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String word[] = line.split("\\s+");
            for (int i = 0; i < word.length; i++) {
                counterByWords.putIfAbsent(word[i], 0);
            }

        }

        bf = new BufferedReader(new FileReader("C:\\IdeaProjects\\Java Advanced\\Resources\\Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
        scanner = new Scanner(bf);


        while (scanner.hasNextLine()) {
            String compareLine = scanner.nextLine();
            String word[] = compareLine.split("\\s+");
            for (int i = 0; i < word.length; i++) {
                if (counterByWords.containsKey(word[i])) {
                    counterByWords.put(word[i], counterByWords.get(word[i]) + 1);

                }
            }
        }
        counterByWords.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> printWriter.println(e.getKey()+" - "+e.getValue()));
    printWriter.close();
    bf.close();
    }
}
