package reflectionAndAnnotationsExercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Class clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();
        Field hiddenValue = clazz.getDeclaredField("innerValue");
        hiddenValue.setAccessible(true);
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String methodsName = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);
            Method method = clazz.getDeclaredMethod(methodsName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);
            System.out.println(hiddenValue.get(blackBoxInt));
            input = scanner.nextLine();
        }

    }
}
