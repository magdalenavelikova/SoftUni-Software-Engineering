package p05_CustomLinkedList;

/**
 * Dynamic (linked) list class definition
 */
public class CustomLinkedList<T> {
    private class ListNode {

        private T element;
        private ListNode nextNode;

        public ListNode(T element) {
            this.setElement(element);
            this.setNextNode(null);
        }

        public ListNode(T element, ListNode prevNode) {
            this.setElement(element);
            prevNode.setNextNode(this);
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public ListNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int count;

    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    /**
     * Gets element at the specified position
     * @param index The position of the element [0 � count-1]
     * @return The item at the specified index
     * @exception IllegalArgumentException When an invalid index is specified
     */
    public T get(int index) {
        if (index >= this.count || index < 0) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        ListNode currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getElement();
    }

    /**
     * Sets element at the specified position
     * @param index The position of the element [0 � count-1]
     * @param element The element which should be set on the given position
     * @return The item at the specified index
     * @exception IllegalArgumentException When an invalid index is specified
     */
    public void set(int index, T element) {
        if (index >= this.count || index < 0) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        ListNode currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }

        currentNode.setElement(element);
    }

    /**
     * Add element at the end of the list
     * @param item The element to be added
     */
    public void add(T item) {
        if (this.head == null) {
            // We have an empty list -> create a new head and tail
            this.head = new ListNode(item);
            this.tail = this.head;
        }
        else {
            // We have a non-empty list -> append the item after tail
            ListNode newNode = new ListNode(item, this.tail);
            this.tail = newNode;
        }

        this.count++;
    }

    /**
     * Removes and returns element on the specified index
     * @param index The index of the element to be removed
     * @return The removed element
     * @exception IllegalArgumentException if the index is invalid
     */
    public T removeAt(int index) {
        if (index >= this.count || index < 0) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        // Find the element at the specified index
        int currentIndex = 0;
        ListNode currentNode = this.head;
        ListNode prevNode = null;
        while (currentIndex < index) {
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }

        // Remove the found element from the list of nodes
        this.removeListNode(currentNode, prevNode);

        // Return the removed element
        return currentNode.getElement();
    }

    /**
     * Removes the specified item and return its index.
     * @param item The item for removal
     * @return The index of the element or -1 if it does not exist
     */
    public int remove(T item) {
        // Find the element containing the searched item
        int currentIndex = 0;
        ListNode currentNode = this.head;
        ListNode prevNode = null;
        while (currentNode != null) {
            if (currentNode.getElement().equals(item)) {
                break;
            }

            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }

        if (currentNode != null) {
            // The element is found in the list -> remove it
            removeListNode(currentNode, prevNode);
            return currentIndex;
        }

        // The element is not found in the list -> return -1
        return -1;
    }

    /**
     * Searches for given element in the list
     * @param item The item to be searched
     * @return The index of the first occurrence of the element in the list or -1 when it is not found
     */
    public int indexOf(T item) {
        int index = 0;
        ListNode currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getElement().equals(item)) {
                return index;
            }

            currentNode = currentNode.getNextNode();
            index++;
        }

        return -1;
    }

    /**
     * Checks if the specified element exists in the list
     * @param item The item to be checked
     * @return True if the element exists or false otherwise
     */
    public boolean contains(T item) {
        int index = this.indexOf(item);
        boolean found = index != -1;
        return found;
    }

    /**
     * Remove the specified node from the list of nodes
     * @param node the node for removal
     * @param prevNode the predecessor of node
     */
    private void removeListNode(ListNode node, ListNode prevNode) {
        this.count--;
        if (count == 0) {
            // The list becomes empty -> remove head and tail
            this.head = null;
            this.tail = null;
        }
        else if (prevNode == null) {
            // The head node was removed --> update the head
            this.head = node.getNextNode();
        }
        else {
            // Redirect the pointers to skip the removed node
            prevNode.setNextNode(node.getNextNode());
        }

        // Fix the tail in case it was removed
        if (this.tail == node) {
            this.tail = prevNode;
        }
    }
}
