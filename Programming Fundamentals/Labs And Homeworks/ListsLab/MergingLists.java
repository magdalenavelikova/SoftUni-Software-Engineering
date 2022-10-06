package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();

        int minSize = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < minSize; i++) {
            int firstListElement = firstList.get(i);
            int secondListElement = secondList.get(i);
            resultList.add(firstListElement);
            resultList.add(secondListElement);

        }
        if (firstList.size() < secondList.size()) {
            resultList.addAll(secondList.subList(minSize,secondList.size()));
        }else{
            resultList.addAll(firstList.subList(minSize,firstList.size()));
        }
        System.out.print(resultList.toString().replaceAll("[\\]\\[,]", ""));
    }
}
