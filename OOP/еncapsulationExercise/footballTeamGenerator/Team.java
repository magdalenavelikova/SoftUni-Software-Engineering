package еncapsulationExercise.footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {



    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
    public void removePlayer(String name) {

           boolean isPlayerRemoved= players.removeIf(player -> player.getName().equals(name));
        if(!isPlayerRemoved){
            throw new IllegalArgumentException("Player "+name+" is not in "+this.getName()+" team.");
        }
    }

   public double getRating() {
        return players.stream().mapToDouble(p->p.overallSkillLevel()).average().orElse(0);
   }
}
