package sandbox.Sortings.MergeSort;

import java.util.Arrays;

/**
 * Time complexity;
 * always O(n^2)
 * <p>
 * Created by alterG on 22.05.2017.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {0, 2, 4, 1, 3, 5};
        merge(a, 0, 3, 5);
        System.out.println(Arrays.toString(a));
    }


    public static void sort(int[] array) {

    }

    /**
     * Recursive function
     *
     * @param array array to sort
     * @param low   bound of array
     * @param high  bound of array
     */
    private static void recSort(int[] array, int low, int high) {

//      array consists one element is sorted by default
        if (low == high) return;

        //        else {
//            int mid = d(low + high) / 2;
//            recSort(array, low, mid); // sort low part of array
//            recSort(array, mid + 1, high); // sort high part of array
//
//        }

    }

    private static void merge(int[] array, int lowPtr, int highPtr, int upperBound) {
        int index = 0;
        int lowerBound = lowPtr;
        int length = upperBound - lowPtr + 1;
        int mid = highPtr - 1;
        int[] result = Arrays.copyOf(array, array.length);

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (result[lowPtr] <= array[highPtr]) {
                result[index++] = array[lowPtr++];
            } else {
                result[index++] = array[highPtr++];
            }
        }

        while (lowPtr <= mid) {
            result[index++] = array[lowPtr++];
        }
        while (highPtr <= upperBound) {
            result[index++] = array[highPtr++];
        }
        System.arraycopy(result, 0, array, lowerBound, length);
    }
}
