package workshopDataStructureExercise;


public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addLast(5);
        linkedList.addLast(6);
        linkedList.addLast(7);

        linkedList.forEach(System.out::print);
        System.out.println();
        System.out.println("Remove first " + linkedList.removeFirst());
        System.out.println("Remove last " + linkedList.removeLast());
        for (int el : linkedList.toArray()) {
            System.out.print(el + " ");
        }
        System.out.println();
        System.out.println("Element " + linkedList.get(3));
        System.out.println(linkedList.get(6));//невалиден индекс

        LinkedListWithTail linkedListWithTail =new LinkedListWithTail();
        linkedListWithTail.addFirst(1);
        linkedListWithTail.addFirst(2);
        linkedListWithTail.addLast(69);
        linkedListWithTail.addLast(73);
        System.out.println(linkedListWithTail.removeFirst());
        System.out.println(linkedListWithTail.removeLast());
        System.out.println();

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(69);
        doubleLinkedList.addLast(3);
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(73);
        doubleLinkedList.forEach(System.out::println);
        System.out.println();
        System.out.println(doubleLinkedList.get(4));
        System.out.println(doubleLinkedList.get(2));
        System.out.println(doubleLinkedList.removeFirst());
        System.out.println(doubleLinkedList.removeLast());
        System.out.println();
    }


}
