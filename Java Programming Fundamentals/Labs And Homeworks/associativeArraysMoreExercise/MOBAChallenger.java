package associativeArraysMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class MOBAChallenger {

    public static class Positions {


        private String position;
        private int skill;

        public Positions(String position, int skill) {

            this.position = position;
            this.skill = skill;
        }


        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public int getSkill() {
            return skill;
        }

        public void setSkill(int skill) {
            this.skill = skill;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        Map<String, List<Positions>> playerMap = new HashMap<>();
        while (!inputLine.equals("Season end")) {
            if (inputLine.contains("->")) {
                String currentPlayer = inputLine.split("\\s+->\\s+")[0];
                String position = inputLine.split("\\s+->\\s+")[1];
                int skill = Integer.parseInt(inputLine.split("\\s+->\\s+")[2]);
                boolean isExist = false;
                Positions positions = new Positions(position, skill);

                playerMap.putIfAbsent(currentPlayer, new ArrayList<>());
                if (!playerMap.get(currentPlayer).isEmpty()) {
                    for (int i = 0; i < playerMap.get(currentPlayer).size(); i++) {
                        if (playerMap.get(currentPlayer).get(i).getPosition().equals(position)) {
                            if (playerMap.get(currentPlayer).get(i).getSkill() < skill) {
                                playerMap.get(currentPlayer).set(i, positions);
                            }
                            isExist = true;
                            break;
                        }
                    }
                }
                if (!isExist) {
                    playerMap.get(currentPlayer).add(positions);
                }
            } else {
                String firstPlayer = inputLine.split("\\s+vs\\s+")[0];
                String secondPlayer = inputLine.split("\\s+vs\\s+")[1];

                if (playerMap.get(firstPlayer) != null && playerMap.get(secondPlayer) != null) {
                    for (Positions positionsForFirstPlayer : playerMap.get(firstPlayer)) {
                        String positionFirstPlayer = positionsForFirstPlayer.getPosition();
                        int skillFirstPlayer = positionsForFirstPlayer.getSkill();
                        for (Positions positionsForSecondPlayer : playerMap.get(secondPlayer)) {
                            String positionSecondPlayer = positionsForSecondPlayer.getPosition();
                            if (positionFirstPlayer.equals(positionSecondPlayer)) {
                                int skillSecondPlayer = positionsForSecondPlayer.getSkill();
                                if (skillFirstPlayer > skillSecondPlayer) {
                                    playerMap.get(secondPlayer).remove(positionsForSecondPlayer);
                                } else {
                                    playerMap.get(firstPlayer).remove(positionsForFirstPlayer);
                                }
                                break;
                            }
                        }
                    }
                }


            }


            inputLine = scanner.nextLine();
        }

        Map<Integer, List<String>> sumOfSkillsByPlayers = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<String, List<Positions>> entry : playerMap.entrySet()) {
            List<Integer> skills = new ArrayList<>();
            for (Positions positions : entry.getValue()) {
                skills.add(positions.getSkill());
            }
            int sum = skills.stream().mapToInt(Integer::intValue).sum();
            if (sum > 0) {
                sumOfSkillsByPlayers.putIfAbsent(sum, new ArrayList<>());
                sumOfSkillsByPlayers.get(sum).add(entry.getKey());
            }
        }

        for (Map.Entry<Integer, List<String>> entry : sumOfSkillsByPlayers.entrySet()) {
            List<String> collect = entry.getValue().stream().sorted()
                    .collect(Collectors.toList());

            for (String s : collect) {
                System.out.printf("%s: %d skill%n", s, entry.getKey());

                Map<Integer, List<String>> sortedSkillsByPositions = new TreeMap<>(Comparator.reverseOrder());
                for (Positions positions : playerMap.get(s)) {
                    sortedSkillsByPositions.putIfAbsent(positions.getSkill(), new ArrayList<>());
                    sortedSkillsByPositions.get(positions.getSkill()).add(positions.getPosition());
                }
                for (Map.Entry<Integer, List<String>> sortedPositions : sortedSkillsByPositions.entrySet()) {
                    List<String> sortedPosition = sortedPositions.getValue().stream().sorted()
                            .collect(Collectors.toList());
                    for (String p : sortedPosition) {
                        System.out.printf("- %s <::> %d%n", p, sortedPositions.getKey());
                    }
                }
            }
        }

    }
}
