package generics.genericArrayCreator;

public class Main {

    public static void main(String[] args) {
        String[] strings = ArrayCreator.create(13, "Generic");

        for (String element : strings) {
            System.out.print(element + " ");
        }
        System.out.println();
        Integer[] integers = ArrayCreator.create(Integer.class, 5, 3);

        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }
}
