package com.codility.lesson9.MaxProfit;

/**
 * Created by alterG on 11.05.2017.
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] A = {8, 9, 3, 6, 1, 2};
        MaxProfit profit = new MaxProfit();
        System.out.println(profit.solution(A));
        }



    public int solution(int[] A) {

        int startPrice =  Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < A.length; i++) {
            int currentProfit = A[i] - startPrice;
            if (currentProfit <= 0) {
                startPrice = A[i];
            }
            else if (maxProfit < currentProfit){
                maxProfit = currentProfit;
            }
        }
        return maxProfit;




/*        int maxProfit = 0;
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i] - A[0];
            if (maxProfit < A[i]) {
                maxProfit = A[i];
            }
        }

        int currentProfit;
        for (int i = A.length - 1; i > 0 ; i--) {
            if (i == 1) {
                currentProfit = A[A.length - 1] - A[i];
            }
            else {
                currentProfit = A[i] - A[i-1];
            }
            if (maxProfit < currentProfit) {
                maxProfit = currentProfit;
            }
        }
        return maxProfit;*/
    }
}
