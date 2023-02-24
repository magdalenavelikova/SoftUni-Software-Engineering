package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String commandLine = scanner.nextLine();
        int bombNumber = Integer.parseInt(commandLine.split(" ")[0]);
        int power = Integer.parseInt(commandLine.split(" ")[1]);
        if (numbersList.contains(bombNumber)) {
            for (int i = 0; i < numbersList.size(); i++) {
                int currentElement = numbersList.get(i);
                if (currentElement == bombNumber) {
                    int startIndex = i - power;
                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    int endIndex = i + power;
                    if (endIndex > numbersList.size() - 1) {
                        endIndex = numbersList.size() - 1;
                    }
                   int counter = (endIndex - startIndex) + 1;
                    /*for (int j = 1; j <= counter; j++) {
                        numbersList.remove(startIndex);
                    }*/
                    for (int j = startIndex; j <=endIndex ; j++) {
                        numbersList.set(j,0);
                    }

                }
            }
        }
        int sum = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            sum += numbersList.get(i);
        }
        System.out.println(sum);
    }
}
