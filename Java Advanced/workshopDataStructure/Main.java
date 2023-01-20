package workshopDataStructure;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        long start = System.currentTimeMillis();
        for (int i = 1; i < 55; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println("=====================SmartArray==========================");
        SmartArray smartArray = new SmartArray();
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

        System.out.println("=======================SmartArrayGenericInteger========================");

        SmartArrayGeneric<Integer> smartArrayGeneric = new SmartArrayGeneric<>();
        for (int i = 0; i < 10; i++) {
            smartArrayGeneric.add(i + 1);
        }
        System.out.println(end - start);
        System.out.println(smartArrayGeneric.get(4));
        System.out.println(smartArrayGeneric.remove(3));
        smartArrayGeneric.add(1, 13);
        System.out.println(smartArrayGeneric.contains(5));
        smartArrayGeneric.forEach(System.out::println);

        System.out.println("====================SmartArrayGenericString===========================");

        SmartArrayGeneric<String> smartArrayString = new SmartArrayGeneric<>();
        for (int i = 0; i < 10; i++) {
            smartArrayString.add("A" + i);
        }
        System.out.println(end - start);
        System.out.println(smartArrayString.get(4));
        System.out.println(smartArrayString.remove(3));
        smartArrayString.add(1, "A");
        System.out.println(smartArrayString.contains("A1"));
        smartArrayString.forEach(System.out::println);

        System.out.println("====================Stack===========================");

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

        System.out.println("======================StackGenericInteger=========================");
        StackGeneric<Integer> stackGenericInteger = new StackGeneric<>();

        stackGenericInteger.push(1);
        stackGenericInteger.push(2);
        stackGenericInteger.push(3);
        stackGenericInteger.push(4);
        System.out.println(stackGenericInteger.peek());
        System.out.println(stackGenericInteger.pop());
        System.out.println(stackGenericInteger.pop());
        System.out.println(stackGenericInteger.pop());
        System.out.println(stackGenericInteger.pop());
        stackGenericInteger.forEach(System.out::println);

        System.out.println("===================StackGenericStrings============================");
        StackGeneric<String> stackGenericStrings = new StackGeneric<>();

        stackGenericStrings.push("A");
        stackGenericStrings.push("B");
        stackGenericStrings.push("C");
        stackGenericStrings.push("D");
        System.out.println(stackGenericStrings.peek());
        System.out.println(stackGenericStrings.pop());
        System.out.println(stackGenericStrings.pop());
        System.out.println(stackGenericStrings.pop());
        System.out.println(stackGenericStrings.pop());
        stackGenericStrings.forEach(System.out::println);
    }

}
