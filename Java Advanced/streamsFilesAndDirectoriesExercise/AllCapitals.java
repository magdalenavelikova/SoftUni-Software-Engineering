package streamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AllCapitals {

    public static void main(String[] args)throws IOException {

        Scanner scanner = new Scanner(new BufferedReader(new FileReader("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt")));
        PrintWriter pw=new PrintWriter("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt");

        while (scanner.hasNext()){
            String input=scanner.nextLine().toUpperCase();
            pw.println(input);
        }
        pw.close();
        scanner.close();


    }
}
