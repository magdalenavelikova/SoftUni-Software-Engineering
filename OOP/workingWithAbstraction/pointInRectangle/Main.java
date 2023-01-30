package workingWithAbstraction.pointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = getCoordinates(scanner);

        Point A = new Point(coordinates[0], coordinates[1]);
        Point C = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(A, C);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            coordinates = getCoordinates(scanner);
            Point X = new Point(coordinates[0], coordinates[1]);
            System.out.println(rectangle.contains(X));
        }
    }

    private static int[] getCoordinates(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
