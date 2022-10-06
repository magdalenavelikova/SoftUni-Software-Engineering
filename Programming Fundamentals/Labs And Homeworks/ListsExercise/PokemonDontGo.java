package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> distanceList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sumOfRemovedElements = 0;
        while (distanceList.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 0 && index < distanceList.size()) {
                int removedElement = distanceList.get(index);
                sumOfRemovedElements += removedElement;
                distanceList.remove(index);
                listManipulator(distanceList, removedElement);
            } else if (index < 0) {
                int removedElement = distanceList.get(0);
                int lastElement=distanceList.get(distanceList.size() - 1);
                sumOfRemovedElements += removedElement;
                distanceList.set(0, lastElement);
                listManipulator(distanceList, removedElement);
            } else if (index > distanceList.size() - 1) {
                int removedElement = distanceList.get(distanceList.size() - 1);
                int firstElement=distanceList.get(0);
                sumOfRemovedElements += removedElement;
                distanceList.set(distanceList.size() - 1, firstElement);
                listManipulator(distanceList, removedElement);
            }
        }
        System.out.println(sumOfRemovedElements);
    }

    public static void listManipulator(List<Integer> nums, int removedElement) {
        for (int i = 0; i < nums.size(); i++) {
            int currentElement = nums.get(i);
            if (currentElement <= removedElement) {
                nums.set(i, currentElement + removedElement);
            } else {
                nums.set(i, currentElement - removedElement);
            }
        }
    }


}
