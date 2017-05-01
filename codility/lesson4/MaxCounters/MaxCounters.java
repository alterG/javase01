package com.codility.lesson4.MaxCounters;

import java.util.Arrays;

/**
 * Created by alterG on 28.04.2017.
 */
public class MaxCounters {
    public static void main(String[] args) {
    int[] A = {3,4,4,6,1,4,4};
    MaxCounters max = new MaxCounters();
    max.solution(5, A);
    }

    public int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int maxCounter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i]<=N && A[i]>=1) {
                result[A[i]-1]++;
                if (result[A[i]-1] > maxCounter) {
                    maxCounter = result[A[i]-1];
                }
            }
            if (A[i] == N + 1) {
                for (int j = 0; j < result.length; j++) {
                    result[j] = maxCounter;
                }
            }
//            System.out.println("op="+A[i]+" matrix is "+ Arrays.toString(result));
        }
        return  result;
    }
}
