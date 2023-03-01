package interfacesAndAbstractionExercise.militaryElite;

public enum SpecialisedSoldierImpl {
    Airforces,
    Marines;

    public static boolean isValidSpecialisedSoldierImpl(String corp) {
        return corp.equals(String.valueOf(SpecialisedSoldierImpl.Airforces)) || corp.equals(String.valueOf(SpecialisedSoldierImpl.Marines));
    }
}
