package streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {

        String path = "C:\\IdeaProjects\\Java Advanced\\Resources\\input.txt";

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            // Scanner scanner = new Scanner(fileInputStream);
            int oneByte = fileInputStream.read();

            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
