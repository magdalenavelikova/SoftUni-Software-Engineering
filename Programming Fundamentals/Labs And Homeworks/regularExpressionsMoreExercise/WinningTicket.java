package regularExpressionsMoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tickets = scanner.nextLine().split("[, ]+");
        for (String ticket : tickets) {
            if (isValid(ticket)) {
                String firstPart = ticket.substring(0, ticket.length() / 2);
                String secondPart = ticket.substring(ticket.length() / 2);
                String firstPartWinningSymbols = getWinningSymbols(firstPart);
                String secondPartWinningSymbols = getWinningSymbols(secondPart);

                if (firstPartWinningSymbols.equals(secondPartWinningSymbols)&&!firstPartWinningSymbols.equals("no match") ) {
                    if (firstPartWinningSymbols.length() == 10) {
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", ticket, firstPartWinningSymbols.length(), firstPartWinningSymbols.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%s%n", ticket, firstPartWinningSymbols.length(), firstPartWinningSymbols.charAt(0));
                    }
                } else {
                    if (firstPartWinningSymbols.equals("no match") || secondPartWinningSymbols.equals("no match")) {
                        System.out.printf("ticket \"%s\" - no match%n", ticket);
                    } else {
                        int minLength = Math.min(firstPartWinningSymbols.length(), secondPartWinningSymbols.length());
                        System.out.printf("ticket \"%s\" - %d%s%n", ticket, minLength, firstPartWinningSymbols.charAt(0));
                    }
                }

            } else {
                System.out.println("invalid ticket");
            }
        }

    }

    private static String getWinningSymbols(String text) {
        String regex = "[\\@]{6,}|[\\#]{6,}|[\\$]{6,}|[\\^]{6,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        }
        return "no match";
    }


    public static boolean isValid(String ticket) {
        return ticket.length() == 20;
    }
}
