package com.codility.lesson5.MinAvgTwoSlice;

/**
 * Created by alterG on 02.05.2017.
 */
public class MinAvgTwoSlice {
    public static void main(String[] args) {
        int[] A = {-3, -5, -8, -4, -10};
        MinAvgTwoSlice a1 = new MinAvgTwoSlice();
        System.out.println(a1.solution(A));
    }
    public int solution(int[] A) {
        double minSum = Integer.MAX_VALUE;
        int indexOfMinSum = -1;
        for (int i = 0; i < A.length-1; i++) {
            if ( (A[i]+A[i+1])/2.0 < minSum) {
                minSum = (A[i]+A[i+1])/2.0;
                indexOfMinSum = i;
//                System.out.println("The new min is "+minSum+" (2index "+indexOfMinSum+")");
            }

            if ( (i < A.length-2) && ((A[i]+A[i+1]+A[i+2])/3.0 < minSum) ) {
                minSum = (A[i]+A[i+1]+A[i+2])/3.0;
                indexOfMinSum = i;
//                System.out.println("The new min is "+minSum+" (3index "+indexOfMinSum+")");
            }
        }
        return indexOfMinSum;
    }
}
