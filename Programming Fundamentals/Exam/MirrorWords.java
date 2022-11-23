package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "([@#])(?<first>[A-Za-z]{3,})\\1{2}(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> hiddenWordPairs = new ArrayList<>();
        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            hiddenWordPairs.add(matcher.group("first") + " <=> " + matcher.group("second"));
        }
        if (!hiddenWordPairs.isEmpty()) {
            for (int i = 0; i < hiddenWordPairs.size(); i++) {
                String firstPart = hiddenWordPairs.get(i).split("<=>")[0];
                String secondPart = hiddenWordPairs.get(i).split("<=>")[1];
                if (firstPart.length() == secondPart.length()) {
                    int lastIndex = firstPart.length() - 1;
                    boolean isMirror = true;
                    for (int j = 0; j < firstPart.length(); j++) {
                        if (firstPart.charAt(j) != secondPart.charAt(lastIndex - j)) {
                            isMirror = false;
                            break;
                        }
                    }
                    if (isMirror) {
                        result.add(hiddenWordPairs.get(i));
                    }
                }
            }
            System.out.println(hiddenWordPairs.size() + " word pairs found!");
            if (result.isEmpty()) {
                System.out.println("No mirror words!");
            } else {
                System.out.println("The mirror words are:");
                System.out.println(String.join(", ", result));
            }
        } else {
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");

        }


    }
}
