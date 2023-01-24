package iteratorsAndComparatorsExercise.linkedListTraversal;


import java.util.Iterator;

public class LinkedList implements Iterable<Node> {
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

    public void add(int element) {
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

    public int getSize() {
        return size;
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


    public boolean removeHead(int element) {
        checkSize();
        Node currentNode = head;
        if (currentNode.value == element) {
            head.next = null;
            head.prev = null;
            size--;
            if (isEmpty()) {
                head = null;
                tail = null;
            }
            return true;
        }


        return false;
    }


    public boolean remove(int element) {
        checkSize();
        if (size < 2) {
            return removeHead(element);
        }
        Node currentNode = head;

        for (int i = 0; i < size; i++) {
            int result = currentNode.value;
            if (result == element) {
                if (size - 1 == i) {
                    tail = currentNode.prev;
                    tail.next = null;

                }
                if (i == 0 && size > 2) {
                    head = currentNode.next;
                    head.prev = null;
                    head.next = currentNode.next.next;
                } else if (i == 0 && size == 2) {
                    head = currentNode.next;
                    head.prev = null;
                    head.next = null;
                }
                if (size - 1 != i && i != 0) {
                    currentNode.next.prev = currentNode.prev;
                    currentNode.prev.next = currentNode.next;
                }
                size--;
                return true;
            }

            currentNode = currentNode.next;

        }


        return false;
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

//    public void forEach(Consumer<Integer> consumer) {
//        Node currentNode = head;
//        while (currentNode != null) {
//            consumer.accept(currentNode.value);
//            currentNode = currentNode.next;
//        }
//    }

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

    @Override
    public Iterator<Node> iterator() {
        return new linkedListIterator();
    }

    private class linkedListIterator implements Iterator<Node> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node next() {
            Node result = current;
            current = current.next;
            return result;
        }
    }
}


