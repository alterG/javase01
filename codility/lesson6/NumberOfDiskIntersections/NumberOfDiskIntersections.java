package com.codility.lesson6.NumberOfDiskIntersections;

import java.util.Arrays;

/**
 * Created by alterG on 03.05.2017.
 */
public class NumberOfDiskIntersections {
    public static void main(String[] args) {
        NumberOfDiskIntersections a1 = new NumberOfDiskIntersections();
        int[] A = {1, 5, 2, 1, 4, 0};
        System.out.println(a1.solution(A));
    }
    public int solution(int[] A) {
        long[] start = new long[A.length];
        long[] end = new long[A.length];

        for (int i = 0; i < A.length; i++) {
            start[i] = (long)(i - A[i]);
            end[i] = (long)(i + A[i]);
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int j = 0;
        long counts = 0;
        for (int i = 0; i < A.length; i++) {
            while (j < A.length && end[i]>=start[j]) {
                counts+=j-i;
                j++;
            }
            if (counts > 10_000_000) return -1;
        }
        return (int)counts;
    }
}
