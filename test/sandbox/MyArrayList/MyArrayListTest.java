package sandbox.MyArrayList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alterG on 30.05.2017.
 */
public class MyArrayListTest {
    MyArrayList<Integer> list;

    // list  = {0 1 2 3 4 5 6 7 8 9}
    @Before
    public void initialize() {
        list = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    @Test
    public void addTest() {
        list.add(11);
        assertEquals(11, list.get(list.size()-1).intValue());
    }

    @Test
    public void removeTest() {
        list.remove(list.size()-2);
        assertEquals(9, list.get(list.size()-1).intValue());
        assertEquals(7, list.get(list.size()-2).intValue());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeTest2() {
        list.remove(100);
    }

}