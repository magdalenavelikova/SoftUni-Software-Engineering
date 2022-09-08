package ExamExercise1;

import java.util.Scanner;

public class ChangeTiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        N – дължината на страна от площадката в интервала [1 … 100].
//        W – широчината на една плочка в интервала [0.1 … 10.00].
//        L – дължината на една плочка в интервала [0.1 … 10.00].
//        М – широчината на пейката в интервала [0 … 10].
//        О – дължината на пейката в интервала [0 … 10].
        int n = Integer.parseInt(scanner.nextLine());
        double w = Double.parseDouble(scanner.nextLine());
        double l = Double.parseDouble(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int o = Integer.parseInt(scanner.nextLine());
        int area = n * n;
        int bench = m * o;
        double tiles = w * l;
        int areaForTiles = area - bench;
        double tilesQuantity = areaForTiles / tiles;
        double time = tilesQuantity * .2;
        System.out.println(tilesQuantity);
        System.out.println(time);
    }
}
