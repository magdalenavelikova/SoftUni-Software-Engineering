package forLoopLabAndExcercise;

public class NumbersEndsWith7 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int numbers = i % 10;
            if (numbers == 7) {
                System.out.println(i);
            }
        }
    }
}
