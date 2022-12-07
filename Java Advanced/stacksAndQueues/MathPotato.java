package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> childrenQueue = new ArrayDeque<>();

        for (String child : children) {
            childrenQueue.offer(child);
        }
        int counter = 0;
        while (childrenQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String currentChild = childrenQueue.poll();
                childrenQueue.offer(currentChild);
            }
            counter++;
            if (isPrime(counter)) {
                System.out.println("Prime " + childrenQueue.peek());

            } else {
                System.out.println("Removed " + childrenQueue.poll());
            }

        }
        System.out.println("Last is " + childrenQueue.poll());

    }

    private static boolean isPrime(int counter) {

        if (counter <= 1) {
            return false;
        }
        for (int i = 2; i <= counter / 2; i++) {
            if ((counter % i) == 0)
                return false;
        }
        return true;

    }


}
