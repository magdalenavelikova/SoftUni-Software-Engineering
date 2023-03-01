package interfacesAndAbstractionExercise.militaryElite;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, String st) {
        this.codeName = codeName;
        if(State.isValidMissionState(st)) {
            this.state = State.valueOf(st);
        }else {
            throw new IllegalArgumentException("No such state!");
        }
    }


    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",codeName,state);
    }
}
