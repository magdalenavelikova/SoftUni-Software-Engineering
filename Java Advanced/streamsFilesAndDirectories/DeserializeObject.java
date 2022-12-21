package streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class DeserializeObject {
    public static class Cube implements Serializable {
        private String color;
        private double width;
        private double height;
        private double depth;
public Cube(){

}
        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "C:\\IdeaProjects\\Java Advanced\\Resources\\save.txt";

        ObjectInputStream oos = new ObjectInputStream(new FileInputStream(path));
//       does not work
        Cube cube = (Cube) oos.readObject();


    }
}
