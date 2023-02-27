package polymorphism.mathOperation;

public class MathOperation {
    private MathOperation() {
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return add(a, add(b, c));
    }

    public static int add(int a, int b, int c, int d) {
        return add(a, add(b, c,d));
    }
}

