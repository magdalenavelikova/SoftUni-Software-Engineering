package reflectionAndAnnotations.gettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();

        Comparator<Method> comparator = Comparator.comparing(Method::getName);

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
        for (Method getter : getters) {
//            •	"{name} will return class {Return Type}"
            System.out.println(getter.getName() + " will return class " + getter.getReturnType().getName());
        }

        for (Method setter : setters) {
//•	"{name} and will set field of class {Parameter Type}"
            System.out.println(setter.getName() + " and will set field of class " + setter.getParameterTypes()[0].getName());
        }

    }

}
