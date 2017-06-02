package sandbox.hashmap;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alterG on 02.06.2017.
 */
public class MyHashMapTest {
    MyHashMap<Integer, String> map;

    @Before
    public void initialize() {
        map = new MyHashMap<>();
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(13, "Threeteen");
        map.put(23, "Twenty Three");
        map.put(33, "i dont remember");
    }

    @Ignore     // don't know how to test this method
    @Test
    public void put() throws Exception {

    }

    @Test
    public void getUnexistingElem() {
        String result = map.get(300);
        assertEquals(null, result);
    }

    @Test
    public void get() throws Exception {
        String result = map.get(4);
        assertEquals("Four", result);
        result = map.get(3);
        assertEquals("Three", result);
        result = map.get(5);
        assertEquals("Five", result);
        result = map.get(4);
        assertEquals("Four", result);
        result = map.get(13);
        assertEquals("Threeteen", result);
        result = map.get(23);
        assertEquals("Twenty Three", result);
        result = map.get(33);
        assertEquals("i dont remember", result);

    }

    @Test
    public void getOrDefault() throws Exception {
        String result = map.getOrDefault(20, "default");
        assertEquals("default", result);
    }

    @Test
    public void size() throws Exception {
        assertEquals(6, map.size());
    }

}