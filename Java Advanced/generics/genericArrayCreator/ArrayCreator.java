package generics.genericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    public static <T> T[] create(int length, T item) {
        return create(item.getClass(), length, item);

    }

    public static <T> T[] create(Class<?> clazz, int length, T item) {

        T[] array = (T[]) Array.newInstance(clazz, length);
        Arrays.fill(array, item);
        return array;
    }
}
