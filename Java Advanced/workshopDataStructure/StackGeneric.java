/**
 * Custom implementation of LIFO structure
 */
package workshopDataStructure;

import java.util.function.Consumer;

public class StackGeneric<T> {

    private static class Node<T> {
        T element;
        private Node<T> prev;

        private Node(T element) {
            this.element = element;
        }


    }

    private Node<T> top;
    private int size;

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.prev = top;
        top = newNode;
        size++;
    }

    public T pop() {
        ensureNotEmpty();
        T last = top.element;
        top = top.prev;
        size--;
        return last;
    }

    private void ensureNotEmpty() {
        if (top == null) {
            throw new IllegalArgumentException("Error! Stack is Empty!");
        }
    }

    public T peek() {
        ensureNotEmpty();
        return top.element;
    }

    public void forEach(Consumer<T> consumer) {
        Node<T> current = top;
        while (current != null) {
            consumer.accept(current.element);
            current = current.prev;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}
