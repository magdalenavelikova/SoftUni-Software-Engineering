package generics.genericScale;


public class Main {

    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(45, 13);
        System.out.println(scale.getHeavier());
        Scale<String> scaleStrings = new Scale<>("A", "B");
        System.out.println(scaleStrings.getHeavier());
    }


}
