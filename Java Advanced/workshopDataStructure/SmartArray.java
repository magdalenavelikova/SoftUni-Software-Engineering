package workshopDataStructure;

import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;

    private int[] grow() {
        int newLength = data.length * 2;
        int[] newData = new int[newLength];
        System.arraycopy(data, 0, newData, 0, data.length);
        return newData;
    }

    private int[] shrink() {
        int newLength = data.length / 2;
        int[] newData = new int[newLength];
        System.arraycopy(data, 0, newData, 0, size);
        return newData;
    }

    private void ensureIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    public SmartArray() {
        this.size = 0;
        this.data = new int[INITIAL_CAPACITY];
    }

    public void add(int element) {
        if (size == data.length) {
            data = grow();
        }
        data[size++] = element;
    }


    public int remove(int index) {
        int removedElement = get(index);
        if (size == data.length / 4) {
            data = shrink();
        }
        if (data.length - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }
        data[size - 1] = 0;
        size--;
        return removedElement;
    }


    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            int next = data[i];
            if (element == next) {
                return true;
            }
        }
        return false;
    }


    public void add(int index, int element) {
        int last = data[size - 1];
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - 1 - index);
        }
        data[index] = element;
        add(last);
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }

    public int get(int index) {
        ensureIndex(index);
        return data[index];
    }

    public int size() {
        return size;
    }


}
