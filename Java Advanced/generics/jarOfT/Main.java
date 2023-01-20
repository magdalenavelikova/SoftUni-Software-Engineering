package generics.jarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> numbers = new Jar<>();

        numbers.add(13);
        numbers.add(15);
        System.out.println(numbers.remove());

        Jar<String> stringJar = new Jar<>();
        stringJar.add("fgdgdfsg");
        stringJar.add("fdsf");
        System.out.println(stringJar.remove());
    }
}
