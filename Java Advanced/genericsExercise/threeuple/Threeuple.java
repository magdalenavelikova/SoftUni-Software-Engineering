package genericsExercise.threeuple;

public class Threeuple<F, S, T> {
    private F first;
    private S second;
    private T third;

    public Threeuple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", first, second, third);
    }
}
