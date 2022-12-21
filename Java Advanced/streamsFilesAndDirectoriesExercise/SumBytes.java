package streamsFilesAndDirectoriesExercise;

import java.io.*;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\IdeaProjects\\Java Advanced\\Resources\\Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();
        long sum = 0;
        while (line != null) {

            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);

            }
            line = bufferedReader.readLine();

        }
        System.out.println(sum);
        bufferedReader.close();
    }
}
