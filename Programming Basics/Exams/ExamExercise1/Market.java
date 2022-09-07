package ExamineExercise1;

import java.util.Scanner;

public class Market {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vegеtablesPrice=Double.parseDouble(scanner.nextLine());
        double fruitPrice= Double.parseDouble(scanner.nextLine());
        int vegetablesWeight = Integer.parseInt(scanner.nextLine());
        int fruitWeight= Integer.parseInt(scanner.nextLine());
        double amount= (vegetablesWeight*vegеtablesPrice + fruitPrice*fruitWeight)/1.94;
        System.out.println(amount);

    }
}
