package sandbox.Sortings.BubbleSort;

import java.util.Arrays;

/**
 * Space complexity O(1)
 * Time complexity average/worst O(n^2), best O(n)
 * Created by alterG on 19.05.2017.
 */
public class BubbleSort {

    public static int[] getSortedCopy(int[] A){
        int[] B = Arrays.copyOf(A, A.length);
        BubbleSort.sort(B);
        return B;
    }

    public static void sort(int[] A) {
    int swapBuffer;
    boolean isSwapped = true;
        while (isSwapped) {
            isSwapped = false;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] > A[i+1]) {
                    swapBuffer = A[i];
                    A[i] = A[i+1];
                    A[i+1] = swapBuffer;
                    isSwapped = true;
                }
            }
        }

    }

}
