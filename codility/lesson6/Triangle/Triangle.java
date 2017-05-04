package com.codility.lesson6.Triangle;

import java.util.Arrays;

/**
 * Created by alterG on 03.05.2017.
 */
public class Triangle {
    public int solution(int[] A) {
        Arrays.sort(A);
        long sum;
        for (int i = 0; i < A.length-2; i++) {
            sum = A[i]+A[i+1];
            if (sum > A[i+2]) return 1;
        }
        return 0;
    }
}
