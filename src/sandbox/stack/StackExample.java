package sandbox.stack;


import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by alterG on 25.05.2017.
 */
public class StackExample {

    public boolean solution(String A) {
        if (A.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        ArrayList<Character> allowSymbols = new ArrayList<>();
        allowSymbols.add('(');
        allowSymbols.add(')');
        allowSymbols.add('[');
        allowSymbols.add(']');
        allowSymbols.add('{');
        allowSymbols.add('}');
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (!allowSymbols.contains(c)) continue;
            switch (c) {
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    stack.push(c);
            }
        }
        return true;

    }

}
