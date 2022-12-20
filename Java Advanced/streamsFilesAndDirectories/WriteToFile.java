package streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile {

    public static void main(String[] args) throws IOException {
        String path = "C:\\IdeaProjects\\Java Advanced\\Resources\\input.txt";
        FileInputStream in = new FileInputStream(path);
        FileOutputStream out=new FileOutputStream("C:\\IdeaProjects\\Java Advanced\\Resources\\output.txt");
        Set<Character> punctuationTable = Set.of(',', '.', '!', '?');
        int oneByte = in.read();

        while (oneByte != -1) {
            char symbol=(char) oneByte;
            if (!punctuationTable.contains(symbol)){
                out.write(symbol);
            }

            oneByte = in.read();
        }
        //   ReadFile readFile= new

    }

}
