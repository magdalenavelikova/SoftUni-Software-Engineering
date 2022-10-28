package objectsAndClassesMoreExercise.teamworkProjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Team {
    private String teamName;
    private String creator;
    private List<String> members=new ArrayList<>();

    public Team() {

    }

    public Team(String teamName, String creator) {
        this.teamName = teamName;
        this.creator = creator;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
public String printList(){
        Collections.sort(members);
        return String.join(System.lineSeparator()+" -- ",members);
    }
    @Override
    public String toString() {

        return String.format("%s%n" +
                " - %s%n" +
                " -- %s",teamName,creator,printList());
    }
}
