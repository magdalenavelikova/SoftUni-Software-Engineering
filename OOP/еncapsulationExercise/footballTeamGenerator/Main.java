package еncapsulationExercise.footballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Team> teamMap = new LinkedHashMap<>();
        while (!input.equals("END")) {
            String[] commandLine = input.split(";");
            String command = commandLine[0];
            String teamName = commandLine[1];
            switch (command) {
                case "Team":
                    try {
                        Team team = new Team(teamName);
                        teamMap.put(teamName, team);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "Add":
                    if (teamMap.containsKey(teamName)) {
                        String name = commandLine[2];
                        int endurance = Integer.parseInt(commandLine[3]);
                        int sprint = Integer.parseInt(commandLine[4]);
                        int dribble = Integer.parseInt(commandLine[5]);
                        int passing = Integer.parseInt(commandLine[6]);
                        int shooting = Integer.parseInt(commandLine[7]);

                        try {
                            Player player = new Player(name, endurance, sprint, dribble, passing, shooting);
                            teamMap.get(teamName).addPlayer(player);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                    } else {
                        printMessage(teamName);
                    }
                    break;
                case "Remove":
                    String playerName = commandLine[2];
                    if (teamMap.containsKey(teamName)) {
                        try{
                            teamMap.get(teamName).removePlayer(playerName);
                        }catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        printMessage(teamName);

                    }
                    break;
                case "Rating":
                    if (teamMap.containsKey(teamName)) {
                        System.out.printf("%s - %d%n", teamName, Math.round(teamMap.get(teamName).getRating()));

                    } else {
                        printMessage(teamName);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

    }

    private static void printMessage(String teamName) {
        System.out.println("Team " + teamName + " does not exist.");
    }
}
