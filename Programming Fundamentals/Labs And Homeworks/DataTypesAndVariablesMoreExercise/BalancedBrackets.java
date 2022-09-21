package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] inputLines = new String[n];
        for (int i = 0; i < n; i++) {
            inputLines[i] = scanner.nextLine();
        }
        boolean isBalanced = false;
        for (int i = 0; i < inputLines.length; i++) {
            if (inputLines[i].equals("(")) {
                isBalanced = false;
                for (int j = i + 1; j < inputLines.length; j++) {
                    if (inputLines[j].equals(")")) {
                        isBalanced = true;
                        inputLines[i] = "open";
                        inputLines[j] = "close";
                        break;
                    }
                }
            }

        }
        if (isBalanced) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }


    }
}
