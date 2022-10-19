package dataTypesAndVariables;

import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int asciiCode=scanner.nextLine().charAt(0);
        if (asciiCode>=65 && asciiCode<=90){
            System.out.println("upper-case");
        } else if (asciiCode>=97 && asciiCode<=122) {
            System.out.println("lower-case");
        }
    }
}
