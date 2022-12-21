package streamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {

    public static void main(String[] args) throws IOException {

        String path = "C:\\IdeaProjects\\Java Advanced\\Resources\\Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();

        while (line != null) {
            long sum = 0;
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);

            }
            line = bufferedReader.readLine();
            System.out.println(sum);
        }
        bufferedReader.close();

    }
}
