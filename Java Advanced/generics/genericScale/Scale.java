package generics.genericScale;

public class Scale<T extends Comparable<T>> {
    private T right;
    private T left;

    public Scale(T right, T left) {
        this.right = right;
        this.left = left;
    }

    public T getHeavier() {
        if (right.compareTo(left) > 0) {
            return right;
        }

        if (right.equals(left)) {
            return null;
        }
        return left;
    }
}
