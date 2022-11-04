package textProcessingLab;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        while (!"end".equals(inputLine)) {
            String reversed = "";
            for (int i = inputLine.length()-1; i >= 0; i--) {
                reversed+=inputLine.charAt(i);
            }
            System.out.printf("%s = %s%n",inputLine,reversed);

            inputLine = scanner.nextLine();
        }
    }
}
