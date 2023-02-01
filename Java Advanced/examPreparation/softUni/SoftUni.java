package examPreparation.softUni;

import java.util.ArrayList;
import java.util.List;


public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }


    public String insert(Student student) {
        if (this.getCapacity() == this.getCount()) {
            return "The hall is full.";
        }
        for (Student studentInfo : data) {
            if (student.getFirstName().equals(studentInfo.getFirstName())
                    && student.getLastName().equals(studentInfo.getLastName())) {
                return "Student is already in the hall.";
            }
        }
        data.add(student);
        return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
    }

    public String remove(Student student) {
        if (data.removeIf(e -> e.getLastName().equals(student.getLastName()) && e.getFirstName().equals(student.getFirstName()))) {
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }
        return "Student not found.";
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : data) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Hall size: %d", this.getCount()));
        for (Student student : data) {
            output.append(System.lineSeparator());
            output.append(student.toString());
        }
        return output.toString();
    }


}
