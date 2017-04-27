package com.codility.lesson3;

/**
 * Created by alterG on 27.04.2017.
 */
public class TapeEquilibrium {

    public int solution(int[] A) {
        int currentSumLeft = 0;
        int currentSumRight = 0;
        int difference;
        for (int i = 0; i < A.length; i++) {
            currentSumLeft +=A[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = A.length-1; i > 0; i--) {
            currentSumLeft -=A[i];
            currentSumRight +=A[i];
            difference = Math.abs(currentSumLeft-currentSumRight);
//            System.out.printf("%d - %d = %d\n", currentSumLeft, currentSumRight, difference);
            if (difference < min) {
                min = difference;
            }
        }
        return min;
    }
}
