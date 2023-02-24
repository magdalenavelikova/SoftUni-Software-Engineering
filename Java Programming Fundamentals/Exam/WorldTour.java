package exam;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        StringBuilder tour = new StringBuilder(inputLine);
        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String command = input.split(":")[0];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(input.split(":")[1]);
                    String text = input.split(":")[2];
                    if (isValidIndex(index, tour)) {
                        tour.insert(index, text);

                    }
                    break;
                case "Remove Stop":
                    int firstIndex = Integer.parseInt(input.split(":")[1]);
                    int secondIndex = Integer.parseInt(input.split(":")[2]);
                    if (isValidIndex(firstIndex, tour) && isValidIndex(secondIndex, tour)) {
                        tour.delete(firstIndex, secondIndex + 1);
                    }
                    break;
                case "Switch":
                    String oldString = input.split(":")[1];
                    String newString = input.split(":")[2];
                    if (tour.toString().contains(oldString)) {
                        String update = tour.toString().replace(oldString, newString);
                        tour = new StringBuilder(update);
                    }
                    break;
            }

            System.out.println(tour);
            input = scanner.nextLine();

        }

        System.out.println("Ready for world tour! Planned stops: " + tour);
    }

    private static boolean isValidIndex(int index, StringBuilder tour) {
        return index >= 0 && index < tour.length();
    }
}
