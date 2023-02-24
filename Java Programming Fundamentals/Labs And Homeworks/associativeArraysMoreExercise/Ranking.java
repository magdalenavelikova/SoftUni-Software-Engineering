package associativeArraysMoreExercise;

import java.util.*;
import java.util.stream.Collectors;


public class Ranking {
    public static class User {
        //    contest and the same user, update the points only
        private String user;
        private String contest;
        private int point;

        public User(String user, String contest, int point) {
            this.user = user;
            this.contest = contest;
            this.point = point;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
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
        Map<String, String> passwordsByContest = new HashMap<>();
        List<User> users = new ArrayList<>();
        while (!inputLine.equals("end of contests")) {
            String contest = inputLine.split(":")[0];
            String password = inputLine.split(":")[1];
            passwordsByContest.put(contest, password);
            inputLine = scanner.nextLine();
        }
        inputLine = scanner.nextLine();
        while (!inputLine.equals("end of submissions")) {
            boolean isExist = false;
            String contest = inputLine.split("=>")[0];
            String password = inputLine.split("=>")[1];
            String username = inputLine.split("=>")[2];
            int points = Integer.parseInt(inputLine.split("=>")[3]);
            if (passwordsByContest.containsKey(contest) && password.equals(passwordsByContest.get(contest))) {
                User user = new User(username, contest, points);
                if (users.isEmpty()) {
                    users.add(user);
                } else {
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getUser().equals(username) && users.get(i).getContest().equals(contest)) {
                            if (users.get(i).getPoint() < points) {
                                users.set(i, user);
                            }
                            isExist = true;
                            break;
                        }
                    }

                    if (!isExist) {
                        users.add(user);
                    }

                }
            }
            inputLine = scanner.nextLine();
        }
        Map<String, List<User>> collect = users.stream()
                .collect(Collectors.groupingBy(user -> user.getUser()));
        Map<String, List<User>> sortedUsers = new TreeMap<>();
        for (Map.Entry<String, List<User>> entry : collect.entrySet()) {
            sortedUsers.put(entry.getKey(), entry.getValue());
        }
        Map<Integer, String> usersByPoints = new TreeMap<>();

        for (Map.Entry<String, List<User>> entry : collect.entrySet()) {
            int sumPoints = 0;
            for (User user : entry.getValue()) {
                sumPoints += user.getPoint();
            }
            usersByPoints.put(sumPoints, entry.getKey());
        }
        String bestUser = Collections.max(usersByPoints.entrySet(), Comparator.comparingInt(Map.Entry::getKey)).getValue();
        Integer maxPoints = Collections.max(usersByPoints.entrySet(), Comparator.comparingInt(Map.Entry::getKey)).getKey();

        System.out.printf("Best candidate is %s with total %d points.%n", bestUser, maxPoints);

        System.out.println("Ranking:");
        for (Map.Entry<String, List<User>> entry : sortedUsers.entrySet()) {
            System.out.println(entry.getKey());
            Map<Integer, String> sortedPoints = new TreeMap<>(Collections.reverseOrder());
            for (User user : entry.getValue()) {
                sortedPoints.put(user.getPoint(), user.getContest());
            }
            for (Map.Entry<Integer, String> points : sortedPoints.entrySet()) {
                System.out.printf("#  %s -> %d%n", points.getValue(), points.getKey());
            }


        }

    }
}
