package com.codility.lesson6.MaxProductofThree;

import java.util.Arrays;

/**
 * Created by alterG on 03.05.2017.
 */
public class MaxProductOfThree {
    public int solution(int[] A) {
        Arrays.sort(A);
        int positive = A[A.length-1]*A[A.length-2]*A[A.length-3];
        int negative = A[A.length-1]*A[1]*A[0];
        return positive>negative?positive:negative;
    }
}
