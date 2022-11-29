package exam;

import java.util.*;
import java.util.stream.Collectors;

public class SoftUniKaraoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participants = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        List<String> songs = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        Map<String, List<String>> awardsByParticipant = new TreeMap<>();
        String command = scanner.nextLine();

        while (!command.equals("dawn")) {
            String participant = command.split(", ")[0];
            String song = command.split(", ")[1];
            String award = command.split(", ")[2];
            if (participants.contains(participant) & songs.contains(song)) {
                if (awardsByParticipant.containsKey(participant)) {
                    boolean isUnique = true;
                    for (String entry : awardsByParticipant.get(participant)) {
                        if (entry.equals(song + ", " + award)) {
                            isUnique = false;
                            break;
                        }
                    }
                    if (isUnique) {
                        awardsByParticipant.get(participant).add(song + ", " + award);
                    }

                } else {
                    awardsByParticipant.put(participant, new ArrayList<>());
                    awardsByParticipant.get(participant).add(song + ", " + award);
                }
            }
            command = scanner.nextLine();
        }
        if (awardsByParticipant.isEmpty()) {
            System.out.println("No awards");
        } else {

            LinkedHashMap<String, List<String>> descBySize = new LinkedHashMap<>();

            awardsByParticipant.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size())
                    .forEachOrdered(x -> descBySize.put(x.getKey(), x.getValue()));

            for (Map.Entry<String, List<String>> entry : descBySize.entrySet()) {
                System.out.printf("%s: %d awards%n", entry.getKey(), entry.getValue().size());

                Collections.sort(entry.getValue());
                for (String s : entry.getValue()) {
                    System.out.printf("--%s%n", s.split(", ")[1]);
                }

            }
        }
    }
}
