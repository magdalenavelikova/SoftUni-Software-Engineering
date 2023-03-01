package interfacesAndAbstractionExercise.militaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends PrivateImpl {
    SpecialisedSoldierImpl specialisedSoldier;
    private List<Mission> missionList;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
     if(specialisedSoldier.isValidSpecialisedSoldierImpl(corp)){
         this.specialisedSoldier = SpecialisedSoldierImpl.valueOf(corp);
     }else {
        throw  new IllegalArgumentException("No Such corp");
     }

        missionList = new ArrayList<>();
    }


    public void addMission(Mission mission) {
        missionList.add(mission);

    }

    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(missionList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary()))
                .append(System.lineSeparator()).append("Corps: " + specialisedSoldier)
                .append(System.lineSeparator())
                .append("Missions:");
        if (getMissions().size() > 0) {
            sb.append(System.lineSeparator());
            getMissions().stream().forEach(m -> sb.append(" ").append(m).append(System.lineSeparator()));
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }
}
