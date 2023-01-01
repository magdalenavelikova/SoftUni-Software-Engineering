package definingClassesExercise.google;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Person> personMap = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            String character = data[1];
            Person person = null;
            if (!personMap.containsKey(name)) {
                person = new Person(name);
                personMap.put(name,person);
            }else {
                person=personMap.get(name);
            }
            Company company = null;
            Pokemon pokemon = null;
            Parent parent = null;
            Car car = null;
            Child child = null;

            switch (character) {
                case "company":
                    company = new Company(data[2], data[3], Double.parseDouble(data[4]));
                    person.setCompany(company);
                    break;
                case "car":
                    car = new Car(data[2], Integer.parseInt(data[3]));
                    person.setCar(car);
                    break;
                case "pokemon":
                    pokemon = new Pokemon(data[2], data[3]);
                    person.getPokemonList().add(pokemon);
                    break;
                case "parents":
                    parent = new Parent(data[2], data[3]);
                    person.getParentList().add(parent);
                    break;
                case "children":
                    child = new Child(data[2], data[3]);
                    person.getChildList().add(child);
                    break;

            }


            input = scanner.nextLine();
        }

        String personName= scanner.nextLine();
        System.out.println(personMap.get(personName).toString());
    }
}
