package genericsExercise.customList;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> {
    private List<T> list = new ArrayList<>();

//    •	void add(T element)
//•	T remove(int index)
//•	boolean contains(T element)
//•	void swap(int index, int index)
//•	int countGreaterThan(T element)
//•	T getMax()
//•	T getMin()

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);

    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swap(int fistIndex, int secondIndex) {
        Collections.swap(list, fistIndex, secondIndex);

    }
    public int countGreaterThan(T element){
      return (int)  list.stream().filter(e->e.compareTo(element)>0).count();
    }

    public T getMax() {
        return this.list.stream().max(Comparable::compareTo).get();
    }

    public T getMin() {
        return this.list.stream().min(Comparable::compareTo).get();
    }



    public T remove(int index) {
        return this.list.remove(index);
    }

    public int size(){
        return this.list.size();
    }

    public T get(int index) {
        return this.list.get(index);
    }

    public void print(){
        for (T element : list) {
            System.out.println(element);
        }

    }
}
