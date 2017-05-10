package com.codility.lesson8.Dominator;

import java.util.Stack;

/**
 * Created by alterG on 11.05.2017.
 */
public class Dominator {
    public int solution(int[] A){
//      Determine leader element
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()) {
                stack.push(A[i]);
            }
            else if (A[i] == stack.peek()) {
                stack.push(A[i]);
            }
            else {
                stack.pop();
            }
        }

//      By task condition function return -1 if array doesnt have leader element
        if (stack.isEmpty()) return -1;
        int leaderCandidate = stack.peek();
        int leaderNumber = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leaderCandidate) {
                leaderNumber++;
            }
        }
        if (leaderNumber <= A.length/2) return -1;

//      Search first index of leader element
        int leaderIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == stack.peek()) {
                leaderIndex = i;
                break;
            }
        }
        return leaderIndex;
    }
}
