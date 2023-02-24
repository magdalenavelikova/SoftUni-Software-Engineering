package firstStepsInCodingLabAndExcercise;

import java.util.Scanner;

public class CircleAreaAndperimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());
        double area = Math.PI * r * r;
        double perimeter = 2 * Math.PI * r;

        System.out.printf("%.2f %n", area);
        System.out.printf("%.2f", perimeter);

    }
}
