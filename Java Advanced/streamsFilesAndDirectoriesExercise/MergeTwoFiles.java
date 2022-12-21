package streamsFilesAndDirectoriesExercise;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MergeTwoFiles {

    public static void main(String[] args) throws IOException {

       /* BufferedWriter bufferedWriter=new BufferedWriter
                (new FileWriter("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt",true));*/

        Path inPath = Paths.get("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt");
        Path outPath = Paths.get("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt");
        List<String> lines = Files.readAllLines(inPath);
        Files.write(outPath, lines);
        inPath = Paths.get("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt");
        lines.clear();
        lines = Files.readAllLines(inPath);
        Files.write(outPath, lines, StandardOpenOption.APPEND);

    }
}
