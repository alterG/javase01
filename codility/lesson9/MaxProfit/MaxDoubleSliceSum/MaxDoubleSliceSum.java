package com.codility.lesson9.MaxProfit.MaxDoubleSliceSum;


/**
 * Created by alterG on 11.05.2017.
 */
public class MaxDoubleSliceSum {
    public static void main(String[] args) {
        int[] A = {6, 1, 5, 6, 4, 2, 9, 4};
        MaxDoubleSliceSum maxd = new MaxDoubleSliceSum();
        System.out.println(maxd.solution(A));
    }
    public int solution(int[] A) {
        if (A.length == 3) return 0;
        int maxEnding = 0;
        int maxSlice = 0;
        int indexLeft = 1;
        int indexRight = 0;

//        Also we need indexes of slice to delete minimal element
        for (int i = 1; i < A.length - 1; i++) {
            if (maxEnding + A[i] < 0) {
                maxEnding = 0;
                indexLeft = i+1;
            }
            else {
                maxEnding+=A[i];
            }

            if (maxSlice <= maxEnding) {
                maxSlice = maxEnding;
                indexRight = i;
            }
        }
//        divide slice trying to maximize its sum
        int minElementInSlice;
        if (indexRight == A.length-2 && indexLeft == 1) {
            minElementInSlice = Integer.MAX_VALUE;
        }
        else {
            minElementInSlice = 0;
        }
        for (int i = indexLeft; i <= indexRight; i++) {
            if (minElementInSlice >= A[i]) {
                minElementInSlice = A[i];
            }
        }

        return maxSlice-minElementInSlice;
    }
}
