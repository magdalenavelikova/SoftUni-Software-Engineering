package genericsExercise.tuple;

public class Tuple <F,S> {
   private F first;
   private S second;



    public Tuple(F first, S second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s",first,second);
    }
}
