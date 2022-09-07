package JavaFirstStepsInCoding;

import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        1.	x – височината на къщата – реално число в интервала [2...100]
//        2.	y – дължината на страничната стена – реално число в интервала [2...100]
//        3.	h – височината на триъгълната стена на прокрива – реално число в интервала [2...100]
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double squareWall = (x * x) * 2 - (1.2 * 2);
        double rectangularWall = (x * y)*2 - 2*(1.5 * 1.5);
        double rectangularRoof = (x * y)*2;
        double triangleRoof = (x * h / 2) * 2;
        double roofPaint= (rectangularRoof + triangleRoof) / 4.3;
        double wallPaint = (squareWall + rectangularWall) / 3.4;

        System.out.printf("%.2f %n", wallPaint);
        System.out.printf("%.2f", roofPaint);

    }

}
