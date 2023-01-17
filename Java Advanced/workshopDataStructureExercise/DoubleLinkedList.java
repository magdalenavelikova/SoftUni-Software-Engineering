package workshopDataStructureExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (!isEmpty()) {
            head.prev = newNode;
            newNode.next = head;
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void addLast(int element) {
        if (!isEmpty()) {
            Node newNode = new Node(element);
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
        } else {
            addFirst(element);
        }
    }

    public int get(int index) {
        isValidIndex(index);
        Node currentNode;
        int counter = 0;
        if (size / 2 < index) {
            currentNode = tail;
            while (counter != (size - 1) - index) {
                currentNode = currentNode.prev;
                counter++;
            }
        } else {
            currentNode = head;
            while (counter != index) {
                currentNode = currentNode.next;
                counter++;
            }
        }
        return currentNode.value;
    }

    public int removeFirst() {
        checkSize();
        Node currentNode = head;
        head = currentNode.next;
        head.prev = null;
        size--;
        if (isEmpty()) {
            head = null;
            tail = null;
        }

        return currentNode.value;
    }


    public int removeLast() {
        checkSize();
        if (size < 2) {
            removeFirst();
        }
        Node currentNode = tail;
        int result = currentNode.value;
        tail = currentNode.prev;
        tail.next = null;
        size--;
        return result;
    }

    public void isValidIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("No such index in the list");
        }
    }

    public void checkSize() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The List is Empty!");
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = head;
        while (currentNode != null) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        List<Integer> result = new ArrayList<>();
        forEach(result::add);
        return result.stream().mapToInt(e -> e).toArray();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
