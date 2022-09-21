package ArraysExercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] peopleInWagon = new int[n];
        int sum = 0;
        for (int i = 0; i < peopleInWagon.length; i++) {
            peopleInWagon[i] = Integer.parseInt(scanner.nextLine());
            sum += peopleInWagon[i];
        }
        for (int i = 0; i < peopleInWagon.length; i++) {
            System.out.print(peopleInWagon[i] + " ");
        }
        System.out.printf("%n%d", sum);
    }
}
