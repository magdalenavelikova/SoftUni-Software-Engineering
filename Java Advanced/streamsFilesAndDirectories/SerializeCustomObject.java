package streamsFilesAndDirectories;

import java.io.*;

public class SerializeCustomObject {

    public static class Cube implements Serializable {
        private String color;
        private double width;
        private double height;
        private double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube("green", 15.3, 12.4, 3.0);
        String path = "C:\\IdeaProjects\\Java Advanced\\Resources\\save.ser";
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);


        oos.writeObject(cube);

        ObjectInputStream ios = new ObjectInputStream(new FileInputStream(path));

        Cube deserializedCube = (Cube) ios.readObject();
        System.out.println();


    }
}
