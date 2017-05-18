package com.codility.lesson10.CountFactors;

/**
 * Created by alterG on 18.05.2017.
 */
public class CountFactors {

    public int solution(int N) {
        if (N == 1) return 1;
        int factors = 0;
        long i = 1;
        while (i*i < N) {
            if (N % i == 0) factors+=2;
            i++;
            if (i*i == N) factors++;
        }
        return factors;
    }
}
