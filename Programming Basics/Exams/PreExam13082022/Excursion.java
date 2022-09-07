package Examine13082022;

import java.util.Scanner;

public class Excursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//Броят на хората в групата – цяло число в интервала [0 … 50]
//2. Броят на нощувките – цяло число в интервала [0 … 2000]
//3. Броят на картите за транспорт – цяло число в интервала [0… 2000]
//4. Броят на билетите за музеи – цяло число в интервала [0 … 2000]
        int people = Integer.parseInt(scanner.nextLine());
        int overnight = Integer.parseInt(scanner.nextLine());
        int transportCards = Integer.parseInt(scanner.nextLine());
        int museumTickets = Integer.parseInt(scanner.nextLine());
        double overnightsCosts = overnight * 20.0;
        double transportCosts = transportCards * 1.60;
        double museumCosts = museumTickets * 6.0;
        double allCosts = (overnightsCosts + transportCosts + museumCosts) * 1.25;
        double groupCosts = people * allCosts;
        System.out.printf("%.2f", groupCosts);

    }
}
