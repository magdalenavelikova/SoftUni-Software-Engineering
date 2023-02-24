package interfacesAndAbstractionExercise.militaryElite;

public class SpyImpl extends SoldierImpl {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber=codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d %nCode Number: %s",getFirstName(),getLastName(),getId(),codeNumber);
    }
}

