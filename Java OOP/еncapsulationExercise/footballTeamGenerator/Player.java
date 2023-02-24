package еncapsulationExercise.footballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;


    private void isStatValid(int stat, String statName) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(statName + " should be between 0 and 100.");
        }
    }

    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        isStatValid(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        isStatValid(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        isStatValid(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        isStatValid(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        isStatValid(shooting, "Shooting");
        this.shooting = shooting;
    }
}
