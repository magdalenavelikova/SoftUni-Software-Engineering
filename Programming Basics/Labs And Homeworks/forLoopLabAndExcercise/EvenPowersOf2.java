package forLoopLabAndExcercise;

import java.util.Scanner;

public class EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        int powerNumber=2;
        double result=0;

        for (int i = 0; i <=n; i+=2) {
            result=Math.pow(2,i);
            System.out.printf("%.0f%n",result);
        }

    }
}
