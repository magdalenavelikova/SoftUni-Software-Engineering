package streamsFilesAndDirectoriesExercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/list.ser"));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Resources/Java-Advanced-Files-and-Streams-Exercises-Resources/list.ser"));

        List<Double> list = new ArrayList<>();
        list.add(2.5);
        list.add(5.5);
        list.add(6.5);
        list.add(7.5);

        objectOutputStream.writeObject(list);
        List<Double> newList= (List<Double>) objectInputStream.readObject();
        newList.stream().forEach(System.out::println);
    }
}
