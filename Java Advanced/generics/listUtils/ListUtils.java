package generics.listUtils;


import java.util.Collections;
import java.util.List;
import java.util.function.Function;


public class ListUtils {


    public static <T extends Comparable<T>> T getMin(List<T> list) {
        isEmpty(list);
        return Collections.min(list);
    }

   public static <T extends Comparable<T>> T getMax(List<T> list) {
        isEmpty(list);
        return Collections.max(list);

    }
    public static <T extends Comparable<T>> T get(List<T> list, Function<List<T>,T> function) {
        isEmpty(list);
        return function.apply(list);
    }


    private static <T> void isEmpty(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty!");
        }
    }


}
