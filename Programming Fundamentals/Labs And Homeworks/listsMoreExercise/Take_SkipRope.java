package listsMoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Take_SkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numberList = new ArrayList<>();
        List<Character> nonNumberList = new ArrayList<>();
        int counter = input.length();
        for (int i = 0; i < counter; i++) {
            int asciiCode = input.charAt(i);
            if (asciiCode >= 48 && asciiCode <= 57) {
                int current = Character.getNumericValue(input.charAt(i));
                numberList.add(current);
                input = input.replaceFirst(String.valueOf(input.charAt(i)), "");
                counter--;
                i -= 1;
            }
        }
        for (int i = 0; i < input.length(); i++) {
            nonNumberList.add(input.charAt(i));
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numberList.get(i));
            } else {
                skipList.add(numberList.get(i));
            }
        }
        String resultString = "";
        int currentPosition = 0;
        for (int i = 0; i < takeList.size(); i++) {
            int characterToSkip = skipList.get(i);
            int characterToTake = takeList.get(i);
            for (int j = currentPosition; j < (currentPosition + characterToTake); j++) {
                if (j < nonNumberList.size()) {
                    resultString += nonNumberList.get(j);
                } else {
                    break;
                }
            }
            currentPosition += characterToTake;
            currentPosition += characterToSkip;
        }
        System.out.println(resultString);
    }
}
