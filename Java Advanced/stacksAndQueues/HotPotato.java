package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");
        ArrayDeque<String> kidsQueue = new ArrayDeque<>();
        for (String kid : kids) {
            kidsQueue.offer(kid);
        }

        int n = Integer.parseInt(scanner.nextLine());
        while (kidsQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String currentChild = kidsQueue.poll();
                kidsQueue.offer(currentChild);
            }
            String childToRemove = kidsQueue.poll();
            System.out.println("Removed " + childToRemove);
        }

        //for (String s : kidsQueue) {
        System.out.println("Last is " + kidsQueue.poll());
        //}


    }
}
