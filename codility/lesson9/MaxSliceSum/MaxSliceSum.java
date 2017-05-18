package com.codility.lesson9.MaxSliceSum;

/**
 * Created by alterG on 11.05.2017.
 */
public class MaxSliceSum {
    public static void main(String[] args) {
        int[] A = {0};
        MaxSliceSum mx = new MaxSliceSum();
        System.out.println(mx.solution(A));
    }

    public int solution(int[] A) {
        int maxSlice = 0;
        int maxEnding = 0;
        boolean sliceIsEmpty = true;
//        slice cant be empty, so if array numbers are all negative, we need to know max (closer to zero) negative number
        int maxNegative = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0 && A[i] > maxNegative) {
                maxNegative = A[i];
            }
            maxEnding = Math.max(0, maxEnding + A[i]);
            if (maxSlice < maxEnding) {
                maxSlice = maxEnding;
                sliceIsEmpty = false;
            }
        }
        return sliceIsEmpty?maxNegative:maxSlice;
    }
}
