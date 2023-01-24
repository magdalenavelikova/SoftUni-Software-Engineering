package iteratorsAndComparatorsExercise.equalityLogic;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Person> treeSet = new TreeSet<>();
        Set<Person> hashSet = new HashSet<>();

        int rows = Integer.parseInt(scanner.nextLine());
        while (--rows >= 0) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]));
            treeSet.add(person);
            hashSet.add(person);

        }
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());


    }
}
