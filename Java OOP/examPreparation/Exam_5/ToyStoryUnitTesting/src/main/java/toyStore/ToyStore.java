package toyStore;

import javax.naming.OperationNotSupportedException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ToyStore {
    private Map<String, Toy> toyShelf;

    public ToyStore() {
        this.toyShelf = new LinkedHashMap<>();
        this.toyShelf.put("A", null);
        this.toyShelf.put("B", null);
        this.toyShelf.put("C", null);
        this.toyShelf.put("D", null);
        this.toyShelf.put("E", null);
        this.toyShelf.put("F", null);
        this.toyShelf.put("G", null);
    }

    public Map<String, Toy> getToyShelf() {
        return Collections.unmodifiableMap(this.toyShelf);
    }

    public String addToy(String shelf, Toy toy) throws OperationNotSupportedException, IllegalArgumentException{
        if (!this.toyShelf.containsKey(shelf)) {
            throw new IllegalArgumentException("Shelf doesn't exist!");
        }

        if (this.toyShelf.get(shelf) != null) {
            throw new IllegalArgumentException("Shelf is already taken!");
        }

        boolean itemExist = getToyShelf().containsValue(toy);

        if (itemExist) {
            throw new OperationNotSupportedException("Toy is already in shelf!");
        }

        toyShelf.put(shelf, toy);
        return String.format("Toy:%s placed successfully!", toy.getToyId());
    }

    public String removeToy(String shelf, Toy toy) {
        if (!this.toyShelf.containsKey(shelf)) {
            throw new IllegalArgumentException("Shelf doesn't exists!");
        }

        if (this.toyShelf.get(shelf) != toy) {
            throw new IllegalArgumentException("Toy in that shelf doesn't exists!");
        }

        this.toyShelf.put(shelf, null);

        return String.format("Remove toy:%s successfully!", toy.getToyId());
    }
}
