package com.codility.lesson4.PermElem;

/**
 * Created by alterG on 27.04.2017.
 */
public class PermElem {
    public static void main(String[] args) {
        int[] A = {4,1,2,3};
        int[] B = {4,1,3};
        PermElem a = new PermElem();
        System.out.println(a.solution(A));
        System.out.println(a.solution(B));

    }
    public int solution(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i]>A.length) return 0;
            B[A[i]-1]++;
        }
        for (int i = 0; i < B.length; i++) {
            if (B[i] == 0) return 0;
        }
        return 1;
    }
}
