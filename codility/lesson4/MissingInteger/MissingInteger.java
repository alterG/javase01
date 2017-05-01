package com.codility.lesson4.MissingInteger;

import java.util.HashSet;

/**
 * Created by alterG on 28.04.2017.
 */
public class MissingInteger {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                set.add(A[i]);
            }
        }
        int result = 1;
        while (set.contains(result)) {
            result++;
        }
        return result;
    }
}
