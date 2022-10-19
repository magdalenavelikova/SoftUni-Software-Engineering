package objectsAndClassesExercise.students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Student> studentsLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String studentData = scanner.nextLine();
            String firstName = studentData.split(" ")[0];
            String lastName = studentData.split(" ")[1];
            double grade = Double.parseDouble(studentData.split(" ")[2]);
            Student currentStudent = new Student(firstName, lastName, grade);
            studentsLists.add(currentStudent);
        }
        studentsLists.sort(Comparator.comparingDouble(Student::getGrade)
                .reversed());

        for (Student student : studentsLists) {
            System.out.println(student.toString());
        }
    }
}
