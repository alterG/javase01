package sandbox.MyStack.BasedOnLinkedList;

import org.junit.Before;
import org.junit.Test;
import sun.invoke.empty.Empty;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 * Created by alterG on 30.05.2017.
 */
public class MyStackArrayTest {
    sandbox.MyStack.BasedOnLinkedList.MyStack<Integer> stack;

    @Before
    public void initialize() {
        stack = new sandbox.MyStack.BasedOnLinkedList.MyStack<>();
    }

    @Test
    public void addTest() {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 9; i >= 0; i--) {
            assertEquals(i, stack.pop().intValue());
        }
    }

    @Test
    public void sizeTest() {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertEquals(10, stack.size());
    }

    @Test (expected = EmptyStackException.class)
    public void emptyStackPop() {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }for (int i = 0; i < 10; i++) {
            stack.pop();
        }
        stack.pop();
        assertTrue(true);
    }

}