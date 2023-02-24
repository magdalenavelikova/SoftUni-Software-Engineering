package objectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    static class Student {
        String firstName;
        String lastName;
        int age;
        String hometown;

        Student(String firstName, String lastName, int age, String hometown) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;

        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getHometown() {
            return this.hometown;
        }

        public int getAge() {
            return this.age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        List<Student> studentsList = new ArrayList<>();

        while (!inputLine.equals("end")) {
            String firstName = inputLine.split(" ")[0];
            String lastName = inputLine.split(" ")[1];
            int age = Integer.parseInt(inputLine.split(" ")[2]);
            String hometown = inputLine.split(" ")[3];
            Student currentStudent = new Student(firstName, lastName, age, hometown);
            studentsList.add(currentStudent);
            inputLine = scanner.nextLine();
        }
        String city = scanner.nextLine();
        for (Student item : studentsList) {
            if (item.getHometown().equals(city)) {
                System.out.printf("%s %s is %d years old%n", item.getFirstName(), item.getLastName(), item.getAge());
            }
        }

    }
}
