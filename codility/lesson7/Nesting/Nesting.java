package com.codility.lesson7.Nesting;

import java.util.Stack;

/**
 * Created by alterG on 04.05.2017.
 */
public class Nesting {
    public static void main(String[] args) {
        Nesting a = new Nesting();
        System.out.println(a.solution("(()(())())"));
    }
    public int solution(String S) {
        if (S.length() == 0) return 1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char currentSymbol = S.charAt(i);
            switch (currentSymbol) {
                case '(':
                    stack.push(currentSymbol);
                    break;
                case ')':
                    if (stack.isEmpty()) return 0;
                    char lastSymbol = stack.peek();
                    if (lastSymbol == '(') stack.pop();
                    else return 0;
                    break;
                default:
                    return 0;
            }
        }
        if (stack.size() == 0) return 1;
        else return 0;
    }
}
