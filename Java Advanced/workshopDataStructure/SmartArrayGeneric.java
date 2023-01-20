package workshopDataStructure;

import java.util.function.Consumer;

public class SmartArrayGeneric<T> {
    private static final int INITIAL_CAPACITY = 4;
    private Object[] data;
    private int size;

    private Object[] grow() {
        int newLength = data.length * 2;
        Object[] newData = new Object[newLength];
        System.arraycopy(data, 0, newData, 0, data.length);
        return newData;
    }

    private Object[] shrink() {
        int newLength = data.length / 2;
        Object[] newData = new Object[newLength];
        System.arraycopy(data, 0, newData, 0, size);
        return newData;
    }

    private void ensureIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    public SmartArrayGeneric() {
        this.size = 0;
        this.data = new Object[INITIAL_CAPACITY];
    }

    public void add(T element) {
        if (size == data.length) {
            data = grow();
        }
        data[size++] = element;
    }


    public T remove(int index) {
        T removedElement = get(index);
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


    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            T next = get(i);
            if (element.equals(next)) {
                return true;
            }
        }
        return false;
    }


    public void add(int index, T element) {
        T last = get(size-1);
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - 1 - index);
        }
        data[index] = element;
        add(last);
    }

    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(get(i));
        }
    }

    @SuppressWarnings("unchecked")

    public T get(int index) {
        ensureIndex(index);
        return (T) data[index];
    }

    public int size() {
        return size;
    }


}
