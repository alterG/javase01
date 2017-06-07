package sandbox.hashmap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    public void ensureCapacityTest() {
        for (int i = 1; i < 300; i++) {
            map.put(Integer.valueOf(33 + i), "wrongAnswer");
            if (i % 10 == 0) {
                assertEquals("Three", map.get(3));
                assertEquals("Four", map.get(4));
                assertEquals("Five", map.get(5));
                assertEquals("Threeteen", map.get(13));
                assertEquals("Twenty Three", map.get(23));
                assertEquals("i dont remember", map.get(33));
            }
        }
    }

    @Test
    public void removeTest() {
        assertEquals("Three", map.get(3));
        map.remove(3);
        assertEquals(null, map.get(3));
        assertEquals("i dont remember", map.get(33));
    }

    @Test
    public void removeTestCollisition() {
        // map.size = 10
        // map.array[3] = 3->13->23->33
        assertEquals("Twenty Three", map.get(23));
        map.remove(23);
        assertEquals(null, map.get(23));
        assertEquals("i dont remember", map.get(33));
    }

    @Test
    public void size() throws Exception {
        MyHashMap<Integer, String> map2 = new MyHashMap<>();
        assertEquals(0, map2.size());
        map2.put(3, "Three");
        map2.put(4, "Four");
        map2.put(5, "Five");
        map2.put(13, "Threeteen");
        map2.put(23, "Twenty Three");
        map2.put(33, "i dont remember");
        assertEquals(6, map2.size);
    }

}