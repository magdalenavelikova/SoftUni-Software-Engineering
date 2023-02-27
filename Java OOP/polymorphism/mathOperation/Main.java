package polymorphism.mathOperation;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(MathOperation.add(2, 2));
        System.out.println(MathOperation.add(3, 3, 3));
        System.out.println(MathOperation.add(4, 4, 4, 4));
    }

}
