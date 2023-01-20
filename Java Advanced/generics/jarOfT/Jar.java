package generics.jarOfT;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> stack;

    public Jar() {
        this.stack = new ArrayDeque<>();
    }

    public void add(T element) {
        stack.push(element);
    }

    public T remove() {
        return stack.pop();
    }
}
