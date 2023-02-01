package examPreparation;

import java.util.*;

public class ClimbThePeaks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> mountainPeaks = new ArrayDeque<>();
        ArrayDeque<Integer> difficultyLevel = new ArrayDeque<>();
        String peaks = "Vihren, Kutelo, Banski Suhodol, Polezhan, Kamenitza";
        Arrays.stream(peaks.split(", ")).forEach(mountainPeaks::offer);
        String difficult = "80, 90, 100, 60, 70";
        Arrays.stream(difficult.split(", ")).map(Integer::parseInt).forEach(difficultyLevel::offer);


        int[] dailyPortions = readIntArr(scanner);
        ArrayDeque<Integer> dailyPortionsStack = new ArrayDeque<>();
        Arrays.stream(dailyPortions).forEach(dailyPortionsStack::push);

        int[] dailyStamina = readIntArr(scanner);
        ArrayDeque<Integer> dailyStaminaQueue = new ArrayDeque<>();
        Arrays.stream(dailyStamina).forEach(dailyStaminaQueue::offer);

        ArrayDeque<String> conqueredPeaks = new ArrayDeque<>();

//•	If the sum is equal or greater than the corresponding Mountain Peak’s Difficulty level from the table below, it means that the peak is conquered. In this case, you should
// remove both quantities from the sequences
// and continue with the next ones towards the next peak.
        int days=7;

        while (days-->0) {
            if(!difficultyLevel.isEmpty() && !dailyPortionsStack.isEmpty() && !dailyStaminaQueue.isEmpty()) {

                int sum = dailyPortionsStack.peek() + dailyStaminaQueue.peek();
                if (sum >= difficultyLevel.peek()) {
                    difficultyLevel.poll();
                    conqueredPeaks.offer(mountainPeaks.poll());
                }
                dailyPortionsStack.pop();
                dailyStaminaQueue.poll();
            }
        }
        if(difficultyLevel.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        }else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if(!conqueredPeaks.isEmpty()){
            System.out.println("Conquered peaks:");
        }
        while (!conqueredPeaks.isEmpty()){
            System.out.println(conqueredPeaks.poll());
        }
    }

    public static int[] readIntArr(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
