package ArraysLab;


import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numberArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        while (numberArr.length > 1) {
            int[] condensedArr = new int[numberArr.length - 1];
            for (int i = 0; i < numberArr.length - 1; i++) {
                condensedArr[i] = numberArr[i] + numberArr[i + 1];
            }
            numberArr = condensedArr;

        }
         System.out.println(numberArr[0]);
    }
}
