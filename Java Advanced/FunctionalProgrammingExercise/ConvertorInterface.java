package functionalProgrammingExercise;

import java.util.Scanner;

public class ConvertorInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String name = scanner.nextLine();
        Converter converter = (text -> "Hello " + text);
        System.out.println(converter.transformText(name));
    }


}
