package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String parentheses = scanner.nextLine();
        boolean isBalanced = true;
        ArrayDeque<String> brackets = new ArrayDeque<>();
        if (parentheses.length() % 2 != 0) {
            isBalanced = false;
        } else {
            for (int i = 0; i < parentheses.length(); i++) {

                if (parentheses.charAt(i) == '{' || parentheses.charAt(i) == '(' || parentheses.charAt(i) == '[') {
                    brackets.push(String.valueOf(parentheses.charAt(i)));
                } else {

                    if (String.valueOf(parentheses.charAt(i)).equals(")") && !brackets.pop().equals("(")) {
                        isBalanced = false;
                        break;
                    } else if (String.valueOf(parentheses.charAt(i)).equals("]") && !brackets.pop().equals("[")) {
                        isBalanced = false;
                        break;
                    } else if (String.valueOf(parentheses.charAt(i)).equals("}") && !brackets.pop().equals("{")) {
                        isBalanced = false;
                        break;
                    }
                }

            }


        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
