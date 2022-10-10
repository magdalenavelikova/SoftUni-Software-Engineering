package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String inputLine = scanner.nextLine();
        int countHits = 0;
        int success = 0;

        while (!inputLine.equals("end")) {
            int firstIndex = Integer.parseInt(inputLine.split(" ")[0]);
            int secondIndex = Integer.parseInt(inputLine.split(" ")[1]);
            countHits++;
            if (!isValidIndexes(elements, firstIndex, secondIndex)) {
                System.out.println("Invalid input! Adding additional elements to the board");
                elements.add(elements.size() / 2, -countHits + "a");
                elements.add(elements.size() / 2, -countHits + "a");
                inputLine = scanner.nextLine();
                continue;
            }
            if (isValidIndexes(elements, firstIndex, secondIndex)) {
                if (elements.get(firstIndex).equals(elements.get(secondIndex))) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", elements.get(firstIndex));
                    if (firstIndex < secondIndex) {
                        elements.remove(secondIndex);
                        elements.remove(firstIndex);
                    } else {
                        elements.remove(firstIndex);
                        elements.remove(secondIndex);
                    }
                    success++;
                } else {
                    System.out.println("Try again!");
                }
            }

            if (elements.isEmpty()) {
                System.out.printf("You have won in %d turns!%n", success);
                break;
            }
            inputLine = scanner.nextLine();
        }
        if (!elements.isEmpty()) {
            System.out.println("Sorry you lose :(");
            for (String item : elements) {
                System.out.print(item + " ");
            }
        }
    }

    public static boolean isValidIndexes(List<String> elements, int first, int second) {
        return (first >= 0 && first <= elements.size() - 1)
                && (second >= 0 && second <= elements.size() - 1)
                && (first != second);
    }
}
