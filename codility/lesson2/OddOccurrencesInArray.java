package com.codility.lesson2;

/**
 * Created by alterG on 27.04.2017.
 */
public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int A[] = new int[]{1,3,1,6,3};
        OddOccurrencesInArray a = new OddOccurrencesInArray();
    }
    public int solution(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }
}
