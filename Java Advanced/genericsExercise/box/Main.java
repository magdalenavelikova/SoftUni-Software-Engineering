package genericsExercise.box;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

//      Problem 1.	Generic Box
      /*  Box<String> box=new Box<>();
        for (int i = 0; i < n; i++) {
            String element= scanner.nextLine();
            box.add(element);

        }
         System.out.println(box.toString());
         */

//             Problem 2.	Generic Box of Integer

      /*  Box<Integer> box = new Box<>();
        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(scanner.nextLine());
            box.add(element);

        }
         System.out.println(box.toString());
         */

        //Problem 3.	Generic Swap Method Strings

      /*  Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String element = scanner.nextLine();
            box.add(element);
        }
        String[] command = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(command[0]);
        int secondIndex = Integer.parseInt(command[1]);
        box.swap(firstIndex, secondIndex);
         System.out.println(box.toString());*/

//             Problem 4.	Generic Swap Method Integers
      /*  Box<Integer> box = new Box<>();
        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(scanner.nextLine());
            box.add(element);

        }
        String[] command = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(command[0]);
        int secondIndex = Integer.parseInt(command[1]);
        box.swap(firstIndex, secondIndex);
         System.out.println(box.toString());
*/

//Problem 5.	Generic Count Method Strings
/*        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String element = scanner.nextLine();
            box.add(element);
        }
        String valueToCompare = scanner.nextLine();

        System.out.println(box.countOfGreaterItems(valueToCompare));
*/
//Problem 5.	Generic Count Method Strings
        Box<Double> box = new Box<>();
        for (int i = 0; i < n; i++) {
            double element = Double.parseDouble(scanner.nextLine());
            box.add(element);
        }
        double valueToCompare = Double.parseDouble(scanner.nextLine());

        System.out.println(box.countOfGreaterItems(valueToCompare));


    }
}
