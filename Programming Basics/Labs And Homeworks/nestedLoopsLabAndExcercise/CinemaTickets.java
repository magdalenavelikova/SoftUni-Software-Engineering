package nestedLoopsLabAndExcercise;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int allStudentTicket = 0;
        int allStandardTicket = 0;
        int allKidTicket = 0;
        int allTicket = 0;

        while (!command.equals("Finish")) {
            int oneMovieTickets = 0;
            int studentTicket = 0;
            int standardTicket = 0;
            int kidTicket = 0;
            String movieName = command;
            int capacity = Integer.parseInt(scanner.nextLine());
            String tickets = scanner.nextLine();
            while (!tickets.equals("End") && !tickets.equals("Finish")) {
                String type = tickets;
                switch (type) {
                    case "student":
                        studentTicket++;
                        break;
                    case "standard":
                        standardTicket++;
                        break;
                    case "kid":
                        kidTicket++;
                        break;
                }
                oneMovieTickets++;
                if (oneMovieTickets >= capacity) {
                    break;
                }
                tickets = scanner.nextLine();
            }
            double percent = (oneMovieTickets * 1. / capacity) * 100.0;
            System.out.printf("%s - %.2f%% full.%n", movieName, percent);
            allTicket += oneMovieTickets;
            allKidTicket += kidTicket;
            allStandardTicket += standardTicket;
            allStudentTicket += studentTicket;
            if (!tickets.equals("Finish")) {
                command = scanner.nextLine();
            }else{
                command = tickets;
            }


        }
//        ⦁	"Total tickets: {общият брой закупени билети за всички филми}"
//⦁	"{процент на студентските билети}% student tickets."
//⦁	"{процент на стандартните билети}% standard tickets."
//⦁	"{процент на детските билети}% kids tickets."
        double percentStudentsTickets = (allStudentTicket * 1. / allTicket) * 100.0;
        double percentStandardsTickets = (allStandardTicket * 1. / allTicket) * 100.0;
        double percentKidsTickets = (allKidTicket * 1. / allTicket) * 100.0;
        System.out.printf("Total tickets: %d%n", allTicket);
        System.out.printf("%.2f%% student tickets.%n", percentStudentsTickets);
        System.out.printf("%.2f%% standard tickets.%n", percentStandardsTickets);
        System.out.printf("%.2f%% kids tickets.%n", percentKidsTickets);


    }
}
