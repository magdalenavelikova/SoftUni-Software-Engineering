package reflectionAndAnnotations.highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();

        Comparator<Method> comparator = Comparator.comparing(Method::getName);

        Set<Field> fields= Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(Field::getName))));

        Set<Method> getters = new TreeSet<>(comparator);
        Set<Method> setters = new TreeSet<>(comparator);

        for (Method method : methods) {
            String methodsName = method.getName();

            if (methodsName.contains("get")) {
                getters.add(method);
            } else if (methodsName.contains("set")) {
                setters.add(method);
            }
        }

        for (Field field : fields) {
            int modifier=field.getModifiers();
            if(!Modifier.isPrivate(modifier)){
                System.out.println(field.getName()+" must be private!");
            }
        }
        for (Method getter : getters) {
            int modifier=getter.getModifiers();
            if(!Modifier.isPublic(modifier)){
                System.out.println(getter.getName()+" have to be public!");
            }
        }

        for (Method setter : setters) {
            int modifier=setter.getModifiers();
            if(!Modifier.isPrivate(modifier)){
                System.out.println(setter.getName()+" have to be private!");
            }
        }

    }

}
