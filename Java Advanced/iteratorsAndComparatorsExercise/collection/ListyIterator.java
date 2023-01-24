package iteratorsAndComparatorsExercise.collection;


import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> collection;
    private int index;

    private class collectionIterator implements Iterator<String> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < collection.size() - 1;
        }

        @Override
        public String next() {
            String element = collection.get(currentIndex);
            currentIndex++;
            return element;
        }
    }

    public ListyIterator(String... element) {
        this.collection = List.of(element);
        index = 0;

    }

    public boolean hasNext() {
        return index < collection.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public void print() {
        if (collection.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        } else {
            System.out.println(collection.get(index));
        }

    }

    @Override
    public Iterator<String> iterator() {
        return new collectionIterator();
    }

    public void printAll() {
        for (String element : collection) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

}
