package objectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student2 {

       private String firstName;
       private String lastName;
       private int age;
       private String hometown;

        Student2(String firstName, String lastName, int age, String hometown) {

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

            if (isStudentExist(studentsList, firstName, lastName)) {
                int index = getIndex(studentsList, firstName, lastName);
                if (index!=-1){
                    studentsList.set(index,currentStudent);
                }
            } else {
                studentsList.add(currentStudent);
            }

            inputLine = scanner.nextLine();
        }
        String city = scanner.nextLine();
        for (Student item : studentsList) {
            if (item.getHometown().equals(city)) {
                System.out.printf("%s %s is %d years old%n", item.getFirstName(), item.getLastName(), item.getAge());
            }
        }

    }

    public static boolean isStudentExist(List<Student> studentsList, String firstName, String lastName) {
        for (Student item : studentsList) {
            if (item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    public static int getIndex(List<Student> studentsList, String firstName, String lastName) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getFirstName().equals(firstName) && studentsList.get(i).getLastName().equals(lastName)) {
                return i;
            }
        }
        return -1;
    }


}
