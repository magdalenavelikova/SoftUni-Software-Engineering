package methodsMoreExercise;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double lineLength = 0;
        boolean isCenterPoint1 = false;
        boolean isCenterPoint3 = false;

        if ((getDistance(x1, y1)) <= (getDistance(x2, y2))) {
            lineLength = getLineLength(x1, x2, y1, y2);
            isCenterPoint1 = true;
        } else {
            lineLength = getLineLength(x2, x1, y2, y1);
        }
        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());
        double lineLength1 = 0;
        if ((getDistance(x3, y3)) <= (getDistance(x4, y4))) {
            lineLength1 = getLineLength(x3, x4, y3, y4);
            isCenterPoint3 = true;
        } else {
            lineLength1 = getLineLength(x4, x3, y4, y3);

        }
        if (lineLength >= lineLength1) {
            if (isCenterPoint1) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x1, y1, x2, y2);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x2, y2, x1, y1);
            }
        } else {
            if (isCenterPoint3) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x3, y3, x4, y4);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x4, y4, x3, y3);

            }
        }

    }

    private static double getDistance(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    private static double getLineLength(double x1, double x2, double y1, double y2) {
        //|AB|² = (y2 - y1)² + (x2 - x1)²
        double x = (x2 - x1);
        double y = (y2 - y1);
        return Math.abs(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));

    }
}

