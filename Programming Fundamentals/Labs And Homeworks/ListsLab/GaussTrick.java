package listsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        //1 2 3 4 5	   ->6 6 3
        int counter = numbersList.size() / 2;
        for (int i = 0; i < counter; i++) {

            int firstNumber = numbersList.get(i);
            int lastNumber = numbersList.get((numbersList.size() - 1));
            numbersList.set(i, firstNumber + lastNumber);
            numbersList.remove(numbersList.size() - 1);
        }
        for (int element : numbersList) {
            System.out.print(element + " ");
        }
    }
}
