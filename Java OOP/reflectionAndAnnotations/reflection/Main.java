package reflectionAndAnnotations.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> clazz = Reflection.class;
        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());
        Arrays.stream(clazz.getInterfaces()).forEach(System.out::println);
        Constructor<Reflection> ctor = clazz.getDeclaredConstructor();
        Constructor<?>[] ctors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : ctors) {
            System.out.println(constructor.getTypeParameters());
        }
        Reflection reflection = ctor.newInstance();
        System.out.println(reflection);
    }

}
