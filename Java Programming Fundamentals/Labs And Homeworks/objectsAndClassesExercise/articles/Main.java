package objectsAndClassesExercise.articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        Article newArticle = new Article(inputLine.split(", ")[0], inputLine.split(", ")[1], inputLine.split(", ")[2]);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String commandLine= scanner.nextLine();
            String command = commandLine.split(": ")[0];
            String newValue = commandLine.split(": ")[1];
            if (command.equals("Edit")) {
                newArticle.edit(newValue);
            } else if (command.equals("ChangeAuthor")) {
                newArticle.changeAuthor(newValue);
            } else if (command.equals("Rename")) {
                newArticle.rename(newValue);
                            }
        }
        System.out.println(newArticle.toString());
    }


}
