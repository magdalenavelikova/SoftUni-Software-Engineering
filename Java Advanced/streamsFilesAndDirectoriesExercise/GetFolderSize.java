package streamsFilesAndDirectoriesExercise;

import java.io.File;
import java.util.ArrayDeque;

public class GetFolderSize {

    public static void main(String[] args) {

        File file = new File("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources");

        ArrayDeque<File> dirQueue = new ArrayDeque<>();

        dirQueue.offer(file);
        int sumBite = 0;

        while (!dirQueue.isEmpty()) {
            File current = dirQueue.poll();
            File[] files = current.listFiles();

            for (File entry : files) {

                if (entry.isDirectory()) {
                    dirQueue.offer(entry);
                } else {
                    sumBite += entry.length();
                }

            }
        }

        System.out.println("Folder size: "+sumBite);
    }
}
