package sandbox.stack;

import org.junit.Before;
import org.junit.Test;
import sandbox.stack.braceValidator.StackExample;

import static org.junit.Assert.*;

/**
 * Created by alterG on 25.05.2017.
 */
public class StackExampleTest {
    StackExample sol;

    @Before
    public void initialize() {
        sol = new StackExample();
    }

    @Test
    public void solutionTest() {
        assertTrue(sol.solution("()"));
        assertTrue(sol.solution("{()}"));
        assertTrue(!sol.solution("{([)}"));
        assertTrue(sol.solution("{(sdfdsf)}"));
        assertTrue(sol.solution(""));
        assertTrue(sol.solution("{()}{()}"));
        assertTrue(sol.solution("aaaaaaaaaa"));
        assertTrue(!sol.solution("]["));
        assertTrue(!sol.solution("["));
    }
}