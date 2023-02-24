package interfacesAndAbstractionExercise.collectionHierarchy;

public class AddCollection extends Collection implements Addable{


    @Override
    public int add(String item) {
        super.items.add(item);
        return items.size()-1;
    }
}
