package conditionalStatementsAdvancedLabAndExcercise;

import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//  •	Първият ред съдържа числото V – Обем на басейна в литри – цяло число в интервала [1…10000].
//•	Вторият ред съдържа числото P1 – дебит на първата тръба за час – цяло число в интервала [1…5000].
//•	Третият ред съдържа числото P2 – дебит на втората тръба за час– цяло число в интервала [1…5000].
//•	Четвъртият ред съдържа числото H – часовете които работникът отсъства – реално число в интервала [1.0…24.00]
        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double pipes = (p1 + p2) * h;
        double percentFullPool = (1 - (v - pipes) / v) * 100;
        double percentP1 = (1 - (pipes - (p1 * h)) / pipes) * 100;
        double percentP2 = (1 - (pipes - (p2 * h)) / pipes) * 100;

        if (pipes <= v) {
            System.out.printf("The pool is %.2f", percentFullPool);
            System.out.print("% full. Pipe 1: ");
            System.out.printf("%.2f", percentP1);
            System.out.print("%. Pipe 2: ");
            System.out.printf("%.2f", percentP2);
            System.out.print("%.");
        } else {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, pipes - v);
        }

    }
}
