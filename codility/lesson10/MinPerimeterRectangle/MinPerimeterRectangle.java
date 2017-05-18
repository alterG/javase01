package com.codility.lesson10.MinPerimeterRectangle;

/**
 * Created by alterG on 18.05.2017.
 */
public class MinPerimeterRectangle {
    public int solution(int N) {
        int minPerimeter = Integer.MAX_VALUE;
        for (int i = 1; i*i <= N; i++) {
            if (N % i == 0) {
                int currentPerimeter = 2*(i + N/i);
                if (currentPerimeter < minPerimeter) {
                    minPerimeter = currentPerimeter;
                }
            }
        }
        return minPerimeter;
    }
}
