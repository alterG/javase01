package sandbox.myqueue;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by alterG on 01.06.2017.
 */
public class QueueOnArrayTest {
    QueueOnArray<Integer> queue;

    @Before
    public void initialize() {
        queue = new QueueOnArray<>();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
    }

    @Test(expected = EmptyStackException.class)
    public void dequeFromEmptyQueue() {
        QueueOnArray<Integer> test = new QueueOnArray<>();
        test.deque();
        fail("no exception");
    }

    @Test
    public void testEnsure() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
    }

    @SuppressWarnings("Duplicates")
    @Test
    public void deque() throws Exception {
        int result = queue.deque();
        assertEquals(5, result);
        result = queue.deque();
        assertEquals(6, result);
        result = queue.deque();
        assertEquals(7, result);
    }

}