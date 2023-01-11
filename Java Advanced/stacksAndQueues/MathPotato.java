package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> childrenQueue = new PriorityQueue<>();

        for (String child : children) {
            childrenQueue.offer(child);
        }
        int cycle = 0;
        while (childrenQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String currentChild = childrenQueue.poll();
                childrenQueue.offer(currentChild);
            }
            cycle++;
            if (isPrime(cycle) ) {
                System.out.println("Prime " + childrenQueue.peek());

            } else {
                System.out.println("Removed " + childrenQueue.poll());
            }

        }
        System.out.println("Last is " + childrenQueue.poll());

    }

    private static boolean isPrime(int cycle) {

        if (cycle <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(cycle); i++) {
            if ((cycle % i) == 0)
                return false;
        }
        return true;
    }


}
