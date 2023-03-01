package interfacesAndAbstractionExercise.militaryElite;



public enum State {
    inProgress,
    finished;

    public static boolean isValidMissionState(String state) {
        return state.equals(String.valueOf(State.finished)) || state.equals(String.valueOf(State.inProgress));
    }


}
