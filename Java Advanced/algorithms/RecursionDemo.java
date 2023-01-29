package algorithms;

public class RecursionDemo {

    public static void main(String[] args) {

        print(1);
    }

    private static void print(int i) {
        if (i > 10) {
            return;
        }
        System.out.println("Pre recursive Call" + i);
        //pre call
        print(++i);
        //post call
        System.out.println("Post recursive Call " + i);
        //backtracking
    }
}
