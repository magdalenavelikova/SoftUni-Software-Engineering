package streamsFilesAndDirectories;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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

    public static void main(String[] args) throws IOException {
        Cube cube = new Cube("green", 15.3, 12.4, 3.0);
        String path = "C:\\IdeaProjects\\Java Advanced\\Resources\\save.txt";
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);



        oos.writeObject(cube);



    }
}
