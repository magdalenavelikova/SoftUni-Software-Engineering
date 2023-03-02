package reflectionAndAnnotationsExercise.barracksWars.core.commands;

import reflectionAndAnnotationsExercise.barracksWars.interfaces.Executable;

public abstract class Command implements Executable {

    private String[] data;


    public Command(String[] data) {
        this.data = data;

    }

    public String[] getData() {
        return data;
    }


}
