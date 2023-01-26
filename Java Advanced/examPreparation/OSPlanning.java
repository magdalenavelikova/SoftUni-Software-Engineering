package examPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlanning {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] task = scanner.nextLine().split(", ");
        String[] threads = scanner.nextLine().split("\\s+");
        int target = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();
        Arrays.stream(task).mapToInt(Integer::parseInt).forEach(taskStack::push);
        Arrays.stream(threads).mapToInt(Integer::parseInt).forEach(threadsQueue::offer);

        while (!threadsQueue.isEmpty()) {
            int threadValue = threadsQueue.peek();
           if(!taskStack.isEmpty()) {
                int taskValue = taskStack.peek();
                if(taskValue==target){
                    System.out.printf("Thread with value %d killed task %d%n",threadValue,taskValue);
                    taskStack.pop();
                    break;
                }
                if (threadValue >= taskValue) {
                    taskStack.pop();
                    threadsQueue.poll();
               }
               threadsQueue.poll();
            }
        }
       while (!threadsQueue.isEmpty()){
            System.out.print(threadsQueue.poll()+" ");
        }
    }


}
