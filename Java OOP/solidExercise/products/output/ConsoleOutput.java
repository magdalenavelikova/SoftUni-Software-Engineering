package solidExercise.products.output;

public class ConsoleOutput implements Output {
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    @Override
    public void outputSum(double sum) {
        System.out.printf((SUM) + "%n", sum);
    }

    @Override
    public void outputAverage(double average) {
        System.out.printf((AVERAGE) + "%n", average);
    }
}
