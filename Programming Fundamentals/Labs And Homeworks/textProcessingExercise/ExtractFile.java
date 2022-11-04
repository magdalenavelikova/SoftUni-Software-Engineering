package textProcessingExercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        int index = path.lastIndexOf('\\');
        int indexOfPoint = path.indexOf('.');
        String fileName = path.substring(index + 1, indexOfPoint);
        String fileExtension = path.substring(indexOfPoint + 1);

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);
    }
}
