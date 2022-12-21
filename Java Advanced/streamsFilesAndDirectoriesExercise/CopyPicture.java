package streamsFilesAndDirectoriesExercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class CopyPicture {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/test.jpg");

        FileOutputStream fos = new FileOutputStream("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/copy.jpg");

        byte[] buffer = new byte[1024];

        while (fis.read(buffer) != -1) {

            fos.write(buffer);
        }
        fis.close();
        fos.close();
    }

}
