package listsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            List<String> commandLine = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = commandLine.get(0);
            switch (command) {
                case "Contains":
                    int number = Integer.parseInt(commandLine.get(1));
                    if (numbersList.contains(Integer.valueOf(number))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String type = commandLine.get(1);
                    if (type.equals("even")) {
                        printEvenElement(numbersList);
                    } else {
                        printOddElement(numbersList);
                    }
                    break;
                case "Get":
//                    Get sum – print the sum of all the numbers
                    System.out.println(getSum(numbersList));
                    break;
                case "Filter":
                    String condition = commandLine.get(1);
                    int numberForFilter = Integer.parseInt(commandLine.get(2));
                    printFilteredElement(numbersList, condition, numberForFilter);
                    break;
            }
            input = scanner.nextLine();

        }
      //  System.out.print(numbersList.toString().replaceAll("[\\[\\],]", ""));

    }

    public static void printFilteredElement(List<Integer> numbersList, String condition, int num) {
               for (int i = 0; i < numbersList.size(); i++) {
                   if(condition.equals(">")) {
                       if (numbersList.get(i)> num){
                           System.out.print(numbersList.get(i) + " ");
                       }
                   } else if (condition.equals("<")) {
                       if (numbersList.get(i)< num){
                           System.out.print(numbersList.get(i) + " ");
                       }
                   }else if (condition.equals("<=")) {
                       if (numbersList.get(i)<= num){
                           System.out.print(numbersList.get(i) + " ");
                       }
                   }else if (condition.equals(">=")) {
                       if (numbersList.get(i)>= num){
                           System.out.print(numbersList.get(i) + " ");
                       }
                   }
               }
        System.out.println();
    }

    public static int getSum(List<Integer> numbersList) {
        int sum = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            sum += numbersList.get(i);
        }
        return sum;
    }

    public static void printEvenElement(List<Integer> numbersList) {
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) % 2 == 0) {
                System.out.print(numbersList.get(i) + " ");
            }
        }
        System.out.println();
    }

    public static void printOddElement(List<Integer> numbersList) {
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) % 2 != 0) {
                System.out.print(numbersList.get(i) + " ");
            }
        }
        System.out.println();
    }
}
