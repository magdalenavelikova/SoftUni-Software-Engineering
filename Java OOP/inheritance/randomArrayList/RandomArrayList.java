package inheritance.randomArrayList;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList<T> extends ArrayList<T> {
    public Object getRandomElement(){
        int index = ThreadLocalRandom.current().nextInt(0, size());
        return this.get(index);
    }
}
