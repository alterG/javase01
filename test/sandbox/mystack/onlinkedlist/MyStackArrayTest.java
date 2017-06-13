package sandbox.mystack.onlinkedlist;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by alterG on 30.05.2017.
 */
public class MyStackArrayTest {
    sandbox.mystack.onlinkedlist.MyStack<Integer> stack;

    @Before
    public void initialize() {
        stack = new sandbox.mystack.onlinkedlist.MyStack<>();
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

    @Test(expected = EmptyStackException.class)
    public void emptyStackPop() {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            stack.pop();
        }
        stack.pop();
        assertTrue(true);
    }

}