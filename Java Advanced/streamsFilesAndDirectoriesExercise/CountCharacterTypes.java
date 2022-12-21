package streamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CountCharacterTypes {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        PrintWriter pw=new PrintWriter("C:\\IdeaProjects\\Java Advanced\\Resources\\Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        Map<String, Integer> counterByType = new LinkedHashMap<>();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', '.', '?',',');
        String line= bufferedReader.readLine();
        counterByType.put("Vowels", 0);
        counterByType.put("Other symbols", 0);
        counterByType.put("Punctuation", 0);

        while (line != null) {

            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);

                if (vowels.contains(symbol)) {
                        counterByType.put("Vowels", counterByType.get("Vowels") + 1);
                } else if (punctuation.contains(symbol)) {
                        counterByType.put("Punctuation", counterByType.get("Punctuation") + 1);
                } else if (symbol != ' ') {
                        counterByType.put("Other symbols", counterByType.get("Other symbols") + 1);
                }
            }
            line= bufferedReader.readLine();
        }
        counterByType.entrySet().forEach(e-> pw.println(e.getKey()+": "+e.getValue()));
        pw.close();
        bufferedReader.close();
    }
}
