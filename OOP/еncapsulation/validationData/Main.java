package еncapsulation.validationData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();

        Optional<Person> person = Optional.empty();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            try {
                person = Optional.of(new Person
                        (input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]))
                );
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
            person.ifPresent(people::add);

        }
        double bonus = Double.parseDouble(reader.readLine());


        for (Person personEntry : people) {
            personEntry.increaseSalary(bonus);
            System.out.println(personEntry);
        }

    }

}
