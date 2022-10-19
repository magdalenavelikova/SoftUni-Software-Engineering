package listsMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> mixedList = new ArrayList<>();
        Collections.reverse(secondList);
        int counter = (Math.min(firstList.size(), secondList.size()));
        for (int i = 0; i < counter; i++) {
            mixedList.add(firstList.get(i));
            mixedList.add(secondList.get(i));
        }
        int elementForFrameFirst = 0;
        int elementForFrameSecond = 0;
        if (firstList.size() == counter) {
            elementForFrameFirst = secondList.get(counter);
            elementForFrameSecond = secondList.get(counter + 1);
        } else {
            elementForFrameFirst = firstList.get(counter);
            elementForFrameSecond = firstList.get(counter + 1);
        }
        int minNumber = Math.min(elementForFrameFirst, elementForFrameSecond);
        int maxNumber = Math.max(elementForFrameFirst, elementForFrameSecond);
        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < mixedList.size(); i++) {
            int currentNum = mixedList.get(i);
            if (currentNum > minNumber && currentNum < maxNumber) {
                sortedList.add(currentNum);
            }
        }
        Collections.sort(sortedList);
        System.out.print(sortedList.toString().replaceAll("[\\]\\[,]", ""));

    }
}
