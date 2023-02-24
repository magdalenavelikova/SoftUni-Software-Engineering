package textProcessingExercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split("\\s+");
        int min = Math.min(inputLine[0].length(), inputLine[1].length());
        int sum = 0;
        for (int i = 0; i < min; i++) {
            sum += inputLine[0].charAt(i) * inputLine[1].charAt(i);
        }
        if (inputLine[0].length() > min)
            for (int i = min ; i < inputLine[0].length(); i++) {
                sum += inputLine[0].charAt(i);
            }
        if (inputLine[1].length() > min)
            for (int i = min ; i < inputLine[1].length(); i++) {
                sum += inputLine[1].charAt(i);
            }


        System.out.println(sum);


    }
}
