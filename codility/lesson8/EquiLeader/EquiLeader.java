package com.codility.lesson8.EquiLeader;

import java.util.Stack;

/**
 * Created by alterG on 10.05.2017.
 */
public class EquiLeader {
    public static void main(String[] args) {
        int[] A = {4,3,4,4,4,3,3};
        EquiLeader test = new EquiLeader();
        System.out.println(test.solution(A));
    }

    public int solution(int[] A) {

        if (A.length == 0) return 0;
        int lead = getLeader(A);
        int leadNumber = 0;
        int count = 0;
        int equiLeaders = 0;

//        Determine how many leader values are in array
        for (int i = 0; i < A.length; i++) {
            if (A[i] == lead) {
                leadNumber++;
            }
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == lead) {
                count++;
                leadNumber--;
            }
            else {
                count--;
            }
            if (count >= 1) {
                if (leadNumber > ((A.length-i-1)/2.0) ) {
                    equiLeaders++;
                }
            }
        }
        return equiLeaders;
    }

    private int getLeader(int[] A) {
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
        return stack.isEmpty()?-1:stack.peek();
    }


}
