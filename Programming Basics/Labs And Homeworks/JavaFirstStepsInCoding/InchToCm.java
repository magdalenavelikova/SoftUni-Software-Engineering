package JavaFirstStepsInCoding;

import java.util.Scanner;

public class InchToCm {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        double inches=Double.parseDouble(scanner.nextLine());
        double centimeters=inches*2.54;
        System.out.println(centimeters);
    }
}
