package associativeArraysMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class Judge {
    public static class User {
        private String username;
        private String contest;
        private int point;

        public User(String user, String contest, int point) {
            this.username = user;
            this.contest = contest;
            this.point = point;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getContest() {
            return contest;
        }

        public void setContest(String contest) {
            this.contest = contest;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        Map<String, List<User>> usersByContests = new LinkedHashMap<>();
        List<User> statisticsForUsers = new ArrayList<>();
        while (!inputLine.equals("no more time")) {
            boolean isExist = false;
            String username = inputLine.split("\\s+->\\s+")[0];
            String currentContest = inputLine.split("\\s+->\\s+")[1];
            int points = Integer.parseInt(inputLine.split("\\s+->\\s+")[2]);
            User user = new User(username, currentContest, points);

            usersByContests.putIfAbsent(currentContest, new ArrayList<>());
            if (!usersByContests.get(currentContest).isEmpty()) {
                for (int i = 0; i < usersByContests.get(currentContest).size(); i++) {
                    if (usersByContests.get(currentContest).get(i).getUsername().equals(username) && usersByContests.get(currentContest).get(i).getContest().equals(currentContest)) {
                        if (usersByContests.get(currentContest).get(i).getPoint() < points) {
                            usersByContests.get(currentContest).set(i, user);
                        }
                        isExist = true;
                        break;
                    }
                }
            }
            if (!isExist) {
                usersByContests.get(currentContest).add(user);
            }
            inputLine = scanner.nextLine();
        }
        for (Map.Entry<String, List<User>> entry : usersByContests.entrySet()) {
            System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().size());
            Map<Integer, List<String>> sortedPointsByUser = new TreeMap<>(Comparator.reverseOrder());

            for (User user : entry.getValue()) {
                statisticsForUsers.add(user);
                sortedPointsByUser.putIfAbsent(user.getPoint(), new ArrayList<>());
                sortedPointsByUser.get(user.getPoint()).add(user.getUsername());
            }
            int counter = 0;
            for (Map.Entry<Integer, List<String>> sortedPointsEntry : sortedPointsByUser.entrySet()) {
                List<String> collect = sortedPointsEntry.getValue().stream().sorted()
                        .collect(Collectors.toList());
                for (String s : collect) {
                    counter++;
                    System.out.printf("%d. %s <::> %d%n", counter, s, sortedPointsEntry.getKey());
                }
            }


        }
        Map<String, List<User>> pointsByUsers = statisticsForUsers.stream()
                .collect(Collectors.groupingBy(user -> user.getUsername()));

        Map<Integer, List<String>> sumOfPointsByUser = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<String, List<User>> entry : pointsByUsers.entrySet()) {
            List<Integer> points = new ArrayList<>();
            for (User user : entry.getValue()) {
                points.add(user.getPoint());
            }
            int sum = points.stream().mapToInt(Integer::intValue).sum();
            sumOfPointsByUser.putIfAbsent(sum, new ArrayList<>());
            sumOfPointsByUser.get(sum).add(entry.getKey());
        }

        System.out.println("Individual standings:");
        int counter = 0;
        for (Map.Entry<Integer, List<String>> entry : sumOfPointsByUser.entrySet()) {

            List<String> collect = entry.getValue().stream().sorted()
                    .collect(Collectors.toList());
            for (String s : collect) {
                counter++;
                System.out.printf("%d. %s -> %d%n", counter, s, entry.getKey());
            }
        }



    }

}
