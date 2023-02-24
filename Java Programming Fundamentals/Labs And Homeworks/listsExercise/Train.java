package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagonsList = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int capacity = Integer.parseInt(scanner.nextLine());
//•	Add {passengers} - add a wagon to the end with the given number of passengers
//•	{passengers} -  find an existing wagon to fit all the passengers (starting from the first wagon)
        String commandline = scanner.nextLine();
        while (!commandline.equals("end")) {
            String command = commandline.split(" ")[0];
            if (command.equals("Add")) {
                int passengers = Integer.parseInt(commandline.split(" ")[1]);
                wagonsList.add(passengers);
            } else {
                int passenger = Integer.parseInt(command);
                for (int i = 0; i < wagonsList.size(); i++) {
                    if (wagonsList.get(i) + passenger <= capacity) {
                        wagonsList.set(i, wagonsList.get(i) + passenger);
                        break;
                    }
                }
            }
            commandline = scanner.nextLine();
        }
        System.out.print(wagonsList.toString().replaceAll("[\\[\\],]", ""));
    }
}
