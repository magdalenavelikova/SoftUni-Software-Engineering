package streamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\IdeaProjects\\Java Advanced\\Resources\\Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
        PrintWriter printWriter=new PrintWriter("C:\\IdeaProjects\\Java Advanced\\Resources\\Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        String line = bufferedReader.readLine();
        int counter = 1;

        while (line != null) {
            printWriter.write(counter + ". " + line+"\n");
            counter++;
            line = bufferedReader.readLine();
        }
        printWriter.close();
        bufferedReader.close();
    }
}
