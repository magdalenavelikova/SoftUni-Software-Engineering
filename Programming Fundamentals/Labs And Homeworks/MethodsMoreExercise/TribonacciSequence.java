package MethodsMoreExercise;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        long a = 1;
        long b = 1;
        long c = 2;
        if (num == 1) {
            System.out.printf("%d ", a);
        } else if (num == 2) {
            System.out.printf("%d %d ", a, b);
        } else if (num == 3) {
            System.out.printf("%d %d %d ", a, b, c);
        } else {
            long d = a + b + c;
            System.out.printf("%d %d %d ", a, b, c);

            for (int i = 4; i <= num; i++) {
                System.out.printf("%d ", d);
                a = b;
                b = c;
                c = d;
                d = a + b + c;


            }
        }
    }

}
