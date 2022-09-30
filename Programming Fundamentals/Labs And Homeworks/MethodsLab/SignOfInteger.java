package MethodsLab;

import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number=Integer.parseInt(scanner.nextLine());
        printSign(number);

    }
    public static void printSign(int number){
        if (number<0){
            System.out.printf("The number %d is negative.%n",number);
        } else if (number>0) {
            System.out.printf("The number %d is positive.%n",number);
        }else{
            System.out.println("The number 0 is zero.");

        }

    }
}
