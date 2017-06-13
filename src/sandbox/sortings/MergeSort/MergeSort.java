package sandbox.Sortings.MergeSort;

/**
 * Created by alterG on 22.05.2017.
 */
public class MergeSort {
    
    public static void sort(int[] array) {
        
    }

    /**
     * Recursive function
     * @param array array to sort
     * @param low bound of array
     * @param high bound of array
     */
    private static void recSort(int[] array, int low, int high) {
        
//      array consists one element is sorted by default
        if (low == high) return;
        else {
            int mid = (low+high)/2;
            recSort(array, low, mid); // sort low part of array
            recSort(array, mid+1, high); // sort high part of array

        }
        
    }

    private static void merge(int[] array, int lowPtr, int highPtr, int upperBound) {
        int index = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;

        while (lowPtr <= mid && highPtr <=upperBound)
    }
}
