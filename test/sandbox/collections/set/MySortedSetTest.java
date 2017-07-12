package sandbox.collections.set;

import org.junit.Before;
import org.junit.Test;
import sandbox.collections.set.difference.navigable.MyNavigableSet;
import sandbox.collections.set.difference.parent.SortedSetAddition;
import sandbox.collections.set.difference.sorted.MySortedSet;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Extends abstract class by simple class is kind of stupidity
 * Collection are equals, when his elements are the same (inherited from TreeSet)
 * Created by alterG on 21.06.2017.
 */
public class MySortedSetTest {
    SortedSetAddition<Integer> set;

    private static final Integer UNEXISTING_ELEM = -2;

    @Before
    public void init() {
        set = new MyNavigableSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
//        set = new MySortedSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void getNextElemTest() {
        assertEquals(4, set.getNextElem(3).intValue());
    }

    @Test
    public void getNextElemNoNext() {
        assertEquals(null, set.getNextElem(10));
    }

    @Test
    public void getNextElemNoElem() {
        assertEquals(null, set.getNextElem(UNEXISTING_ELEM));
    }

    @Test
    public void getPrevElemsOk() {
        SortedSetAddition<Integer> expect = new MySortedSet(Arrays.asList(1, 2, 3, 4, 5, 6));
        SortedSetAddition<Integer> outcome = set.getPrevElems(7);
        assertEquals(expect, outcome);
    }

    @Test
    public void getPrevElemsNoElem() {
//        SortedSetAddition<Integer> exp = new MySortedSet<>(Collections.emptySet());
        SortedSetAddition<Integer> exp = new MyNavigableSet<>(Collections.emptySet());
        assertEquals(exp, set.getPrevElems(UNEXISTING_ELEM));
    }
}