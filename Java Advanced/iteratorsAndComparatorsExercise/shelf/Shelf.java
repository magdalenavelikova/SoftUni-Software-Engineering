package iteratorsAndComparatorsExercise.shelf;

import java.util.Iterator;
import java.util.List;

public class Shelf implements Iterable<String> {
    private List<String> products;

    private class Seller implements Iterator<String> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < products.size();
        }

        @Override
        public String next() {
            String current = products.get(index);
            index++;
            return current;

        }
    }

    public Shelf(String... products) {
        this.products = List.of(products);
    }


    @Override
    public Iterator<String> iterator() {
        return new Seller();
    }
}
