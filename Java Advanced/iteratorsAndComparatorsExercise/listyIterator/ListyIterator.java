package iteratorsAndComparatorsExercise.listyIterator;



import java.util.List;

public class ListyIterator {
    private List<String> collection;
    private int index;

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

}
