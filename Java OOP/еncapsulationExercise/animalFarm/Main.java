package еncapsulationExercise.animalFarm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        try{
            Chicken chicken=new Chicken(name,age);
            System.out.print(chicken);
            System.out.printf("can produce %.2f eggs per day.",chicken.productPerDay());

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
