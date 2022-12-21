package streamsFilesAndDirectoriesExercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/result.txt");
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/result.zip"));


        ZipEntry zipEntry = new ZipEntry("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/result.txt");
        zipOutputStream.putNextEntry(zipEntry);

        byte[] buffer = new byte[1024];
        int length;
        while ((length=fileInputStream.read(buffer)) >0) {
            zipOutputStream.write(buffer, 0, length);
        }
        fileInputStream.close();
        zipOutputStream.close();
    }

}
