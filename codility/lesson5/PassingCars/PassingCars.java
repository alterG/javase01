package com.codility.lesson5.PassingCars;

/**
 * Created by alterG on 02.05.2017.
 */
public class PassingCars {
    public int solution(int[] A) {
        int sum = 0;    //number of passing cars
        int carsToWest = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1) {
                carsToWest++;
            }
            else {
                sum+=carsToWest;
            }
            if (sum > 1_000_000_000) return -1;
        }
        return sum;
    }
}
