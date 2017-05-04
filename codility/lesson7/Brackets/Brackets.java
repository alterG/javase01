package com.codility.lesson7.Brackets;

import java.util.Stack;

/**
 * Created by alterG on 04.05.2017.
 */
public class Brackets {
    public static void main(String[] args) {
        String S = "{[()()]}";
        Brackets a1 = new Brackets();
        System.out.println(a1.solution(S));
    }
    public int solution(String S) {
    boolean ok = true;
    Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char current = S.charAt(i);
            char analog;
            switch (current) {
                case ')':
                    analog = '(';
                    if(equalLast(analog, stack)) stack.pop();
                    else return 0;
                    break;
                case ']':
                    analog = '[';
                    if(equalLast(analog, stack)) stack.pop();
                    else return 0;
                    break;
                case '}':
                    analog = '{';
                    if(equalLast(analog, stack)) stack.pop();
                    else return 0;
                    break;
                default:
                    stack.push(S.charAt(i));
                    break;
            }
        }
        return stack.isEmpty()?1:0;
    }

    private boolean equalLast(char analog, Stack<Character> stack) {
        if (stack.isEmpty()) return false;
        char last = stack.peek();
        if (analog != last)   return false;
        else return true;
    }
}
