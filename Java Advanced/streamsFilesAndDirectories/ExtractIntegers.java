package streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\IdeaProjects\\Java Advanced\\Resources\\input.txt";
        FileInputStream in = new FileInputStream(path);
        Scanner scanner = new Scanner(in);
        PrintWriter out =
                new PrintWriter(new FileOutputStream( "C:\\IdeaProjects\\Java Advanced\\Resources\\out.txt"));

        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                out.println(scanner.nextInt());
            }else {
                scanner.next();
            }
        }
        out.close();
    }
}
