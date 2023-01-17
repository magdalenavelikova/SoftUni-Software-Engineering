package workshopDataStructureExercise;


import java.util.function.Consumer;

public class LinkedList {
    private Node head;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (!isEmpty()) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public void addLast(int element) {
        Node newNode = new Node(element);
        if (!isEmpty()) {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        } else {
            head = newNode;
        }
        size++;
    }

    public int get(int index) {
        isValidIndex(index);
        int counter = 0;
        Node currentNode = head;
        while (counter != index) {
            currentNode = currentNode.next;
            counter++;
        }
        return currentNode.value;
    }

    public int removeFirst() {
        checkSize();
        Node currentNode = head;
        head = currentNode.next;
        size--;
        return currentNode.value;
    }


    public int removeLast() {
        checkSize();
        Node currentNode = head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        int result = currentNode.next.value;
        currentNode.next = null;
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
        int[] result = new int[size];
        Node currentNode = head;
        for (int i = 0; i < result.length; i++) {
            result[i] = currentNode.value;
            currentNode = currentNode.next;
        }
        return result;
    }


    public boolean isEmpty() {
        return size == 0;
    }
}


