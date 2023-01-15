package workshopDataStructure;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        SmartArray smartArray = new SmartArray();
        long start = System.currentTimeMillis();
        for (int i = 1; i < 55; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            smartArray.add(i + 1);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(smartArray.get(4));
        System.out.println(smartArray.remove(3));
        smartArray.add(1, 13);
        System.out.println(smartArray.contains(5));
        smartArray.forEach(System.out::println);

        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.forEach(System.out::println);
    }

}
