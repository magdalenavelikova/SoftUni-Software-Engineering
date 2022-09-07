package JavaFirstStepsInCoding;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        
        int pen=Integer.parseInt(scanner.nextLine());
        int marker=Integer.parseInt(scanner.nextLine());
        int detersive=Integer.parseInt(scanner.nextLine());
        int discount=Integer.parseInt(scanner.nextLine());

        double sum=((pen*5.8) + (marker*7.2) + (detersive*1.2));
        double amount=sum-(sum*(discount/100.));
        System.out.println(amount);




    }
}
