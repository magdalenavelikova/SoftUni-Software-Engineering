package generics.listUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list=List.of(10,15,16,90);

        System.out.println(ListUtils.getMin(list));
        System.out.println(ListUtils.getMax(list));
    }
}
