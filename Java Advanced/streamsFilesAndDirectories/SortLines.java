package streamsFilesAndDirectories;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {

    public static void main(String[] args) throws IOException {
        String path = "C:\\IdeaProjects\\Java Advanced\\Resources\\input.txt";
        Path paths = Paths.get(path);
        FileInputStream in = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String outputPath = "Resources/06.SortLinesOutput.txt";
        PrintWriter writer = new PrintWriter(outputPath);
        List<String> lineList = Files.readAllLines(paths);
        Collections.sort(lineList);
        lineList.stream().forEach(e -> writer.println(e) );
        writer.close();
    }
}
