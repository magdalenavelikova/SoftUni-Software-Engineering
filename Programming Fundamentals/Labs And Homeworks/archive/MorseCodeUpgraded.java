package archive;

import java.util.Scanner;

public class MorseCodeUpgraded {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] decryptedWord = scanner.next().split("\\|");
        for (String symbol : decryptedWord) {
            int sum = 0;
            long countZero = symbol.chars().filter(ch -> ch == '0').count();
            long countOne = symbol.chars().filter(ch -> ch == '1').count();
            sum += (countZero * 3) + (countOne * 5);
            int counterForDuplicates = 1;
            for (int i = 0; i < symbol.length() - 1; i++) {
                if (symbol.charAt(i) == symbol.charAt(i + 1)) {
                    counterForDuplicates++;
                } else if (counterForDuplicates > 1) {
                    sum += counterForDuplicates;
                    counterForDuplicates = 1;
                }
            }
            if (counterForDuplicates > 1) {
                sum += counterForDuplicates;
            }
            char currentChar = (char) (sum);

            System.out.print(currentChar);
        }

    }
}
