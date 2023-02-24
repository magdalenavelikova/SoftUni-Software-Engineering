package nestedLoopsLabAndExcercise;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int number=1;
        boolean isBigger=false;
        for (int rows = 1; rows <= n; rows++) {
            for (int column = 1; column <=rows ; column++) {
                if(number>n){
                    isBigger=true;
                    break;
                }
                System.out.print(number+" ");
                number++;

            }
            if (isBigger){
                break;
            }
            System.out.println();
        }

    }
}
