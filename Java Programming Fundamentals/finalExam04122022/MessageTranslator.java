package finalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        String regex = "!(?<command>[A-Z][a-z]{2,})!:\\[(?<string>[A-Za-z]{8,})\\]";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < row; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                System.out.print(matcher.group("command") + ": " );
                String string=matcher.group("string");
                for (int j = 0; j <string.length() ; j++) {
                    int number=string.charAt(j);
                    System.out.print(number+" ");
                }
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }
        }




    }
}
