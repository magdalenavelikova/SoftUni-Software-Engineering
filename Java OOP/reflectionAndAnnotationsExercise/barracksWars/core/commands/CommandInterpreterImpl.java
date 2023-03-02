package reflectionAndAnnotationsExercise.barracksWars.core.commands;

import reflectionAndAnnotationsExercise.barracksWars.annotations.Inject;
import reflectionAndAnnotationsExercise.barracksWars.interfaces.CommandInterpreter;
import reflectionAndAnnotationsExercise.barracksWars.interfaces.Executable;
import reflectionAndAnnotationsExercise.barracksWars.interfaces.Repository;
import reflectionAndAnnotationsExercise.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String UNITS_PACKAGE_NAME =
            "reflectionAndAnnotationsExercise.barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String className = UNITS_PACKAGE_NAME + parseCommandToClassName(commandName);

        Executable command = null;
        try {
            Class clazz = Class.forName(className);
            Constructor<Command> declaredConstructor = clazz.getDeclaredConstructor(String[].class);
            declaredConstructor.setAccessible(true);
            command = declaredConstructor.newInstance(new Object[]{data});
//            Inject
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {
                    if (field.getType().equals(Repository.class)) {
                        field.setAccessible(true);
                        field.set(command, repository);
                    }else  if (field.getType().equals(UnitFactory.class)) {
                        field.setAccessible(true);
                        field.set(command, unitFactory);
                    }
                }
            }

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return command;

    }

    private String parseCommandToClassName(String commandName) {
        String command = commandName.substring(0, 1).toUpperCase();
        return command + commandName.substring(1) + "Command";

    }
}
