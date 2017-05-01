package com.codility.lesson5.DivCount;

/**
 * Created by alterG on 28.04.2017.
 */
public class DivCount {
    public int solution(int A, int B, int K) {
        return B/K-A/K+((A%K == 0)?1:0);
    }
}
