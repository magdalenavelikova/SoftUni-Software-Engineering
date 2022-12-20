package streamsFilesAndDirectories;

import java.io.*;


public class WriteEveryThirdLine {

    public static void main(String[] args) throws IOException {
        String path = "C:\\IdeaProjects\\Java Advanced\\Resources\\input.txt";
        FileInputStream in = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        PrintWriter writer=new PrintWriter("Resources\\out.txt");
        String line = reader.readLine();
        int counter = 1;
        while (line != null) {

            line = reader.readLine();
            counter++;
            if (counter % 3 == 0) {
writer.println(line);
            }
        }
        writer.close();
    }
}
