package ListsLab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble).collect(Collectors.toList());
        for (int i = 0; i < numbersList.size() - 1; i++) {
            double currentNum = numbersList.get(i);
            double nextNum = numbersList.get(i + 1);
            if (currentNum == nextNum) {
                numbersList.set(i + 1, currentNum + nextNum);
                numbersList.remove(i);
                i =-1;
            }

        }
        System.out.println(joinElementsByDelimiter(numbersList," "));

    }
    public static String joinElementsByDelimiter(List<Double> numbersList, String delimiter) {
        String result = "";
        for (Double element : numbersList) {
            DecimalFormat df = new DecimalFormat("0.#");
            result += df.format(element) + delimiter;

        }
        return result;
    }
}
