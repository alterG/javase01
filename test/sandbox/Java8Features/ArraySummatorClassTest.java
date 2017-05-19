package sandbox.Java8Features;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TDD (Test Dream Development) - firstly writing tests, then writing code to pass it
 * Created by alterG on 19.05.2017.
 */
public class ArraySummatorClassTest {

    @Test
    public void simpleArray() {
        int[] A = {5,7,3,8,3};
        assertEquals(26, new ArraySummatorClass().arraySum(A));
    }

    @Test
    public void emptyArray() {
        int[] A = {};
        assertEquals(0, new ArraySummatorClass().arraySum(A));
    }

    @Test(expected = NullPointerException.class)
    public void nullArray() {
        int[] A;
        new ArraySummatorClass().arraySum(null);
        fail("There should be an exception, cause argument is null.");
    }

}