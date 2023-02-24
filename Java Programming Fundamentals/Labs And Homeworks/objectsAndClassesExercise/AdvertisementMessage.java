package objectsAndClassesExercise;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can't live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String phrase = phrases[getRandomIndex(phrases)];
            String event = events[getRandomIndex(events)];
            String author = authors[getRandomIndex(authors)];
            String city = cities[getRandomIndex(cities)];
            System.out.println(phrase + " " + event + " " + author + " - " + city);

        }

    }

    public static int getRandomIndex(String[] array) {
        Random rdn = new Random();
        return rdn.nextInt(array.length);
    }
}
