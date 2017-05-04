package com.codility.lesson6.Distinct;

import java.util.Arrays;

/**
 * Created by alterG on 03.05.2017.
 */
public class Distinct {
    public int solution(int[] A) {
        if (A.length == 0) return 0;
        int[] sortedA = Arrays.copyOf(A, A.length);
        Arrays.sort(sortedA);
        int sum = 1;
        for (int i = 0; i < sortedA.length-1; i++) {
            if (sortedA[i] != sortedA[i+1]) {
                sum++;
            }
        }
        return sum;
    }
}
