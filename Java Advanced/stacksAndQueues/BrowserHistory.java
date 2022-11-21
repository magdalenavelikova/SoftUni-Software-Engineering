package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        String currentUrl = "blank";
        while (!input.equals("Home")) {
            if (!input.equals("back")) {
                if (!currentUrl.equals("blank")) {
                    stack.push(currentUrl);
                }
                currentUrl = input;
                System.out.println(currentUrl);
            } else {
                if (!stack.isEmpty()) {
                    currentUrl = stack.pop();
                    System.out.println(currentUrl);
                } else {
                    System.out.println("no previous URLs");
                }
            }

            input = scanner.nextLine();

        }
    }
}
