/**
 * Custom implementation of LIFO structure
 */
package workshopDataStructure;

import java.util.function.Consumer;

public class Stack {

    private static class Node {
        int element;
        private Node prev;

        private Node(int element) {
            this.element = element;
        }


    }

    private Node top;
    private int size;

    public void push(int element) {
        Node newNode = new Node(element);
        newNode.prev = top;
        top = newNode;
        size++;
    }

    public int pop() {
        enshureNotEmpty();
        int last = top.element;
        top = top.prev;
        size--;
        return last;
    }

    private void enshureNotEmpty() {
        if (top == null) {
            throw new IllegalArgumentException("Error");
        }
    }

    public int peek() {
        enshureNotEmpty();
        return top.element;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = top;
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
