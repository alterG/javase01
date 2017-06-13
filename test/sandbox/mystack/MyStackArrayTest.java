package sandbox.mystack;

import org.junit.Before;
import org.junit.Test;
import sandbox.mystack.onarray.MyStackArray;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;

/**
 * Created by alterG on 30.05.2017.
 */
public class MyStackArrayTest {
    MyStackArray<Integer> stack;

    @Before
    public void initialize() {
        stack = new MyStackArray<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
    }

    @Test
    public void popTest() {
        assertEquals(9, stack.pop().intValue());
        assertEquals(8, stack.pop().intValue());
        assertEquals(7, stack.pop().intValue());
        assertEquals(6, stack.pop().intValue());
        assertEquals(5, stack.pop().intValue());
        assertEquals(4, stack.pop().intValue());
        assertEquals(3, stack.pop().intValue());
        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());
        assertEquals(0, stack.pop().intValue());
    }

    @Test(expected = EmptyStackException.class)
    public void popTestException () {
        for (int i = 0; i < 10; i++) {
            stack.pop();
        }
        stack.pop();
    }

    @Test
    public void add100Elems() {
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        assertEquals(true, true);
    }

}