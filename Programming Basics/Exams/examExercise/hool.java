package examExercise;

import java.util.Scanner;

public class hool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double l = Double.parseDouble(scanner.nextLine()) * 100;
        double w = Double.parseDouble(scanner.nextLine()) * 100;
        double countWorkSpaceL = Math.floor(l / 120);
        double countWorkSpaceW = Math.floor((w - 100) / 70);
        double workSpace = (countWorkSpaceL * countWorkSpaceW) - 3;
        System.out.println(workSpace);
    }

}
