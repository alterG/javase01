package com.codility.lesson4.FrogRiverOne;

/**
 * Created by alterG on 28.04.2017.
 */
public class FrogRiverOne {
    public int solution(int X, int[] A) {
        int[] B = new int[X];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (B[A[i]-1] != 1) {
                B[A[i]-1]++;
                sum++;
                if (sum == X) return i;
            }
        }
        return -1;
    }
}
