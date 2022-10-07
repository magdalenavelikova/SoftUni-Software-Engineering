package ListsMoreExercise;

import java.util.*;


public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] raceArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> leftCarTimeList = new ArrayList<>();
        List<Integer> rightCarTimeList = new ArrayList<>();
        for (int i = 0; i < raceArray.length; i++) {
            int count = raceArray.length / 2;
            if (i < count) {
                leftCarTimeList.add(raceArray[i]);
            } else if (i > count) {
                rightCarTimeList.add(raceArray[i]);
            }
        }
        Collections.reverse(rightCarTimeList);

        if (getSumOfTimes(leftCarTimeList) < getSumOfTimes(rightCarTimeList)) {
            System.out.printf("The winner is left with total time: %.1f", getSumOfTimes(leftCarTimeList));
        } else {
            System.out.printf("The winner is right with total time: %.1f", getSumOfTimes(rightCarTimeList));
        }
    }

    public static double getSumOfTimes(List<Integer> times) {
        double sum = 0;
        for (int i = 0; i < times.size(); i++) {
            if (times.get(i) != 0) {
                sum += times.get(i);
            } else {
                sum = sum * 0.8;
            }
        }
        return sum;
    }
}
