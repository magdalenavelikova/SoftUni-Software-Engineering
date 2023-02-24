package interfacesAndAbstractionExercise.militaryElite;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, String st) {
        this.codeName = codeName;
        this.state = State.valueOf(st);
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",codeName,state);
    }
}
