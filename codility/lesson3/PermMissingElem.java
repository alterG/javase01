package com.codility.lesson3;

/**
 * Created by alterG on 27.04.2017.
 */
public class PermMissingElem {
    public static void main(String[] args) {
        int[] A = {2,3,1,5,6,7,9,4};
        PermMissingElem a = new PermMissingElem();
        System.out.println(a.solution(A));
    }
    public int solution(int[] A) {
        int[] B = new int[A.length+2];
        for (int i = 0; i < B.length; i++) {
            B[i] = 0;
        }
        for (int i = 0; i < A.length; i++) {
            B[A[i]] = 1;
        }
        for (int i = 1; i < B.length; i++) {
            if (B[i] == 0) return i;
        }
        return -1;
    }
}
