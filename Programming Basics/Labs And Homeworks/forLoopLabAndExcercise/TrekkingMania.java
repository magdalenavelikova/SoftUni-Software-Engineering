package forLoopLabAndExcercise;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//⦁	На първия ред – броя на групите от катерачи – цяло число в интервала [1...1000]
//⦁	За всяка една група на отделен ред – броя на хората в групата – цяло число в интервала [1...1000]
        int groupCount = Integer.parseInt(scanner.nextLine());
        int peopleMusala = 0;
        int peopleMontBlanc = 0;
        int peopleKilimanjaro = 0;
        int peopleK2 = 0;
        int peopleEverest = 0;
        double percentMusala = 0;
        double percentMontBlanc = 0;
        double percentKilimanjaro = 0;
        double percentK2 = 0;
        double percentEverest = 0;

        int allPeople = 0;
        for (int i = 0; i < groupCount; i++) {
            int peoplePerGroup = Integer.parseInt(scanner.nextLine());
            //⦁	Група до 5 човека – изкачват Мусала
            //⦁	Група от 6 до 12 човека – изкачват Монблан
            //⦁	Група от 13 до 25 човека – изкачват Килиманджаро
            //⦁	Група от 26 до 40 човека –  изкачват К2
            //⦁	Група от 41 или повече човека – изкачват Еверест
            if (peoplePerGroup <= 5) {
                peopleMusala += peoplePerGroup;
            } else if (peoplePerGroup <= 12) {
                peopleMontBlanc += peoplePerGroup;
            } else if (peoplePerGroup <= 25) {
                peopleKilimanjaro += peoplePerGroup;
            } else if (peoplePerGroup <= 40) {
                peopleK2 += peoplePerGroup;
            } else  {
                peopleEverest += peoplePerGroup;
            }
            allPeople += peoplePerGroup;
        }
        percentMusala = (peopleMusala / (allPeople * 1.0))*100;
        percentMontBlanc = (peopleMontBlanc / (allPeople * 1.0))*100;
        percentKilimanjaro = (peopleKilimanjaro / (allPeople * 1.0))*100;
        percentK2 = (peopleK2 / (allPeople * 1.0))*100;
        percentEverest = (peopleEverest / (allPeople * 1.0))*100;
        System.out.printf("%.2f",percentMusala);
        System.out.println("%");
        System.out.printf("%.2f",percentMontBlanc);
        System.out.println("%");
        System.out.printf("%.2f",percentKilimanjaro);
        System.out.println("%");
        System.out.printf("%.2f",percentK2);
        System.out.println("%");
        System.out.printf("%.2f",percentEverest);
        System.out.println("%");

    }
}
