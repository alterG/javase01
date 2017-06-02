package sandbox.myqueue;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;

/**
 * Created by alterG on 01.06.2017.
 */
public class QueueOnLinkedListTest {
    private QueueOnLinkedList<Integer> queue;

    @Before
    public void initialize() {
        queue = new QueueOnLinkedList<>();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
    }

    @Test
    public void deque() throws Exception {
        int result = queue.deque();
        assertEquals(5, result);
        result = queue.deque();
        assertEquals(6, result);
        result = queue.deque();
        assertEquals(7, result);
    }

    @Test(expected = EmptyStackException.class)
    public void dequeFromEmptyQueue() {
        QueueOnLinkedList<Integer> test = new QueueOnLinkedList<>();
        test.deque();
    }

    @Test(expected = EmptyStackException.class)
    public void size() {
        int result = queue.size();
        assertEquals(3, result);
        queue.deque();
        result = queue.size();
        assertEquals(2, result);
        queue.deque();
        result = queue.size();
        assertEquals(1, result);
        queue.deque();
        queue.deque();
    }

    @Test
    public void enqueue() throws Exception {
        QueueOnLinkedList<Integer> test = new QueueOnLinkedList<>();
        test.enqueue(3);
        test.enqueue(4);
        int result = test.deque();
        assertEquals(3, result);
        result = test.deque();
        assertEquals(4, result);

    }

}