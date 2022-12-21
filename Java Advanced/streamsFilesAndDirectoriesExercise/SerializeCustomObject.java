package streamsFilesAndDirectoriesExercise;

import java.io.*;


public class SerializeCustomObject {
    public static class Courses implements Serializable {
        String name;
        Integer numberOfStudents;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Courses course = new Courses();
        course.name = "TEST";
        course.numberOfStudents = 154;

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/courses.ser"));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/courses.ser"));
        out.writeObject(course);
        Courses deserializedObject = (Courses) in.readObject();
        System.out.println(deserializedObject.name + " - " + deserializedObject.numberOfStudents);

    }
}
