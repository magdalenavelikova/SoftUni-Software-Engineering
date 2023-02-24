package interfacesAndAbstractionExercise.collectionHierarchy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        List<String> input = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        int removeOperationsCounter = Integer.parseInt(scanner.nextLine());
        performAddOperations(input, addCollection);
        performAddOperations(input, addRemoveCollection);
        performAddOperations(input, myList);
        performRemoveOperations(removeOperationsCounter,addRemoveCollection);
        performRemoveOperations(removeOperationsCounter,myList);


    }

    public static void performRemoveOperations(int counter,AddRemovable addRemovable){
        for (int i = 0; i < counter; i++) {
            System.out.print(addRemovable.remove()+" ");
        }
        System.out.println();
    }
    public static void performAddOperations(List<String> input, Addable addable) {
        for (String s : input) {
            System.out.print(addable.add(s) + " ");
        }
        System.out.println();
    }

}
