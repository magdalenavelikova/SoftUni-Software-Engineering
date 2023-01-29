package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int key = Integer.parseInt(scanner.nextLine());


        System.out.println(binarySearch(array, key));
    }

    public static int binarySearch(int arr[], int key) {
        int first = 0;
        int last = arr.length - 1;
        int mid = first + (last - first) / 2;
        while (first <= last) {
            if (key < arr[mid]) {
                last = mid - 1;

            } else if (key > arr[mid]) {
                first = mid + 1;

            } else {
                return (mid);
            }
            mid = first + (last - first) / 2;
        }

        return -1;

    }
}
