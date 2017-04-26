package com.codility.lesson2;

import java.util.Arrays;

/**
 * Created by alterG on 27.04.2017.
 */
public class CycleRotation {
    public static void main(String[] args) {
        CycleRotation a = new CycleRotation();
        int[] A = {1, 2, 3 , 4 , 5, 6, 7};
        System.out.println(Arrays.toString(a.solution(A, 3)));
    }
    /**
     * Author pays attention on correctness, performance is not important
     * that's why method shit array K times instead of one shift on K elements
     * @param A array to rotate
     * @param K number of shifts
     * @return shifted array
     */
    public int[] solution(int[] A, int K) {
        for (int i = 0; i < K; i++) {
            int buf1 = 0;       //don't need to initialize
            int buf2 = A[A.length-1];
            for (int j = 0; j < A.length; j++) {
                if (j % 2 == 0) {
                    buf1 = A[j];
                    A[j] = buf2;
                }
                else {
                    buf2 = A[j];
                    A[j] = buf1;
                }
            }
        }
        return A;
    }
}
