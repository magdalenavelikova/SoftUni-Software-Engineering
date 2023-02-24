package archive;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> usernamesByDomains = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String email = scanner.nextLine();
            String regex = "^(?<username>[A-Za-z]{5,})@(?<mailServer>[a-z]{3,}).(?<TLD>bg|com|org)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.find()) {
                String domain = matcher.group("mailServer").concat(".").concat(matcher.group("TLD"));
                usernamesByDomains.putIfAbsent(domain, new ArrayList<>());
                if (usernamesByDomains.get(domain).isEmpty()) {
                    usernamesByDomains.get(domain).add(matcher.group("username"));
                } else {
                    if (!usernamesByDomains.get(domain).contains(matcher.group("username"))) {
                        usernamesByDomains.get(domain).add(matcher.group("username"));
                    }

                }
            }
        }
        LinkedHashMap<String, List<String>> descBySize = new LinkedHashMap<>();

        usernamesByDomains.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size())
                .forEachOrdered(x -> descBySize.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, List<String>> entry : descBySize.entrySet()) {
            System.out.println(entry.getKey()+":");
            for (String user : entry.getValue()) {
                System.out.println("### " + user);
            }
        }
    }
}
