package com.codility.lesson7.StoneWall;

import java.util.Stack;

/**
 * Created by alterG on 04.05.2017.
 */
public class StoneWall {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int h : H) {
            while (!stack.isEmpty() && stack.peek() > h) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < h) {
                stack.push(h);
                count++;
            }
        }
        return count;
    }
}
