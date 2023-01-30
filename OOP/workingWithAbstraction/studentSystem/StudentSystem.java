package workingWithAbstraction.studentSystem;

import java.util.HashMap;
import java.util.Map;

//shift+F6 - rename all
public class StudentSystem {
    private Map<String, Student> studentsByName;

    public StudentSystem() {
        this.studentsByName = new HashMap<>();
    }

    public Map<String, Student> getStudentsByName() {
        return this.studentsByName;
    }

    public void ParseCommand(String[] args) {
        String command = args[0];
        String name = args[1];
        if (command.equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);

            if (!studentsByName.containsKey(name)) {
                Student student = new Student(name, age, grade);
                studentsByName.put(name, student);
            }
        } else if (command.equals("Show")) {
            Student student = studentsByName.get(name);

            if (student != null) {

                String studentInfo = student.getStudentInfo();
                System.out.println(studentInfo);
            }
        }
    }


}
