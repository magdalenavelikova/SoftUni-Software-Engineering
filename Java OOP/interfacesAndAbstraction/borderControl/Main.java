package interfacesAndAbstraction.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<Identifiable> identifiableList = new ArrayList<>();
        while (!input[0].equals("End")) {
            Identifiable identifiable;
            if (input.length == 3) {

                String name = input[0];
                int age = Integer.parseInt(input[1]);
                String id = input[2];
                identifiable = new Citizen(name, age, id);
            } else {
                String model = input[0];
                String id = input[1];
                identifiable = new Robot(model, id);
            }
            identifiableList.add(identifiable);
            input = scanner.nextLine().split("\\s+");
        }

        String lastDigits = scanner.nextLine();

        identifiableList.stream().filter(i -> i.getId().endsWith(lastDigits))
                .forEach((Identifiable i) -> System.out.println(i.getId()));
    }
}
