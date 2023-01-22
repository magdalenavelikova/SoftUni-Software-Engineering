package genericsExercise.customList;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {

        for (int i = 0; i < customList.size(); i++) {
            T currentElement = customList.get(i);
            for (int j = 0; j < customList.size() - i - 1; j++) {
                if (currentElement.compareTo(customList.get(j + 1)) > 0) {
                    customList.swap(i, j + 1);
                }
            }

        }
    }
}



