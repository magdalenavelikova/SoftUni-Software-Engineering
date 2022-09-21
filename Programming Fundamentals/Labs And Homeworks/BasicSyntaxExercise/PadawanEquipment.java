package BasicSyntaxExercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amountOfMoney = Double.parseDouble(scanner.nextLine());
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        double priceOfLightsabers = Double.parseDouble(scanner.nextLine());
        double priceOfRobes = Double.parseDouble(scanner.nextLine());
        double priceOfBelts = Double.parseDouble(scanner.nextLine());
        double countOfLightsabers = Math.ceil(countOfStudents * 1.1);
        double cost = countOfLightsabers * priceOfLightsabers;
        cost += countOfStudents * priceOfRobes;
        int countOfFreeBelt = countOfStudents / 6;
        cost += (countOfStudents * priceOfBelts) - countOfFreeBelt * priceOfBelts;
        if (amountOfMoney >= cost) {
            System.out.printf("The money is enough - it would cost %.2flv.", cost);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", cost - amountOfMoney);

        }
    }
}
//Because the lightsabers sometimes break, George Lucas should buy 10% more, rounded up to the next integer. Also, every sixth belt is free.