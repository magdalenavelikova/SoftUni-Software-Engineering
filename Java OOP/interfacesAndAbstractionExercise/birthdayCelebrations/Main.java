package interfacesAndAbstractionExercise.birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Birthable> birthables = new ArrayList<>();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            Birthable birthable;
            String name = tokens[1];

            switch (type) {
                case "Citizen":
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthDate = tokens[4];
                    birthable = new Citizen(name, age, id, birthDate);
                    birthables.add(birthable);
                    break;
                case "Pet":
                    String birthDatePet = tokens[2];
                    birthable = new Pet(name, birthDatePet);
                    birthables.add(birthable);
                    break;
                case "Robot":

                    break;



            }
            input = scanner.nextLine();

        }
        String yearOfBirth= scanner.nextLine();
        boolean isFound=false;

        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(yearOfBirth)){
                isFound=true;
                System.out.println(birthable.getBirthDate());
            }

        }
        if(!isFound){
            System.out.println("<no output>");
        }

    }

}
