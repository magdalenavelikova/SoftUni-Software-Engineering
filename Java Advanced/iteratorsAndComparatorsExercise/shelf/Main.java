package iteratorsAndComparatorsExercise.shelf;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Shelf shelf=new Shelf("Product 1","Product 2","Product 3","Product 4");
        Iterator<String> seller=shelf.iterator();

        while (seller.hasNext()){
            System.out.println(seller.next());
        }
        System.out.println();

    }
}
