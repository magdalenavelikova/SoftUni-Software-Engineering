package forLoopLabAndExcercise;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameActor = scanner.nextLine();
        double pointsAcademy = Double.parseDouble(scanner.nextLine());
        double pointForNominations = pointsAcademy;
        int jury = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < jury; i++) {
            String nameJury = scanner.nextLine();
            int length = nameJury.length();
            double points = Double.parseDouble(scanner.nextLine());
            pointForNominations += ((length * points) / 2);

            if (pointForNominations > 1250.5) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", nameActor, pointForNominations);
                i = jury * 2;
            }
        }
        if (pointForNominations <= 1250.5) {
            System.out.printf("Sorry, %s you need %.1f more!", nameActor, 1250.5 - pointForNominations);
        }


    }
}
