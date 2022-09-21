package ArraysMoreExercise;

import java.math.BigInteger;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] stringArray = new String[1];
        if (n > 0) {
            stringArray[0] = "1";
            System.out.println("1");
        }
        for (int i = 1; i < n; i++) {
            String[] tempArray = new String[i + 1];
            tempArray[0] = "1";
            for (int j = 1; j < tempArray.length; j++) {
                if (j < tempArray.length - 1) {
                    BigInteger firstElement = new BigInteger(stringArray[j - 1]);
                    BigInteger secondElement = new BigInteger(stringArray[j]);
                    BigInteger sum = new BigInteger("0");
                    sum = sum.add(firstElement).add(secondElement);
                    tempArray[j] = sum.toString();
                } else {
                    tempArray[j] = "1";
                }
            }
            for (String item : tempArray)
            {
                System.out.print(item + " ");
            }
            System.out.println();
            stringArray = tempArray;
        }
    }
}

