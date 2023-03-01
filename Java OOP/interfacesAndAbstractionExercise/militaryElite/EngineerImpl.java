package interfacesAndAbstractionExercise.militaryElite;

import java.util.*;

public class EngineerImpl extends PrivateImpl {
    SpecialisedSoldierImpl specialisedSoldier;
    List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);

        this.specialisedSoldier = SpecialisedSoldierImpl.valueOf(corp);
        repairs = new ArrayList<>();

    }


    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(repairs);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary()))
                .append(System.lineSeparator()).append("Corps: " + specialisedSoldier)
                .append(System.lineSeparator())
                .append("Repairs:");
        if (getRepairs().size() > 0) {
            sb.append(System.lineSeparator());
            repairs.stream().forEach(r -> sb.append(" ").append(r).append(System.lineSeparator()));
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString().trim();
    }

}
