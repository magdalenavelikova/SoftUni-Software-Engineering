package DataTypesAndVariables;

import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine= scanner.nextLine();
        String secondLine= scanner.nextLine();
        String delimiter= scanner.nextLine();
        System.out.printf("%s%s%s",firstLine,delimiter,secondLine);
    }
}
