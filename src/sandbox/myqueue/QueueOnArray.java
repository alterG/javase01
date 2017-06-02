package sandbox.myqueue;

import java.util.EmptyStackException;

/**
 * Created by alterG on 01.06.2017.
 */
public class QueueOnArray<E> implements sandbox.myqueue.Queue {
    private final int INITIAL_SIZE = 5;


    Object[] array;
    int first;
    int last;
    int size;

    public QueueOnArray() {
        array = new Object[INITIAL_SIZE];
        first = 0;
        last = 0;
    }

    private int nextIndex(int i) {
        return (i+1)%array.length;
    }

    private void ensureCapacity() {
        Object[] temp = new Object[array.length*3/2];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = array[(first+i)%array.length];
        }
        last = array.length - 1;
        first = 0;
        array = temp;
    }

    @Override
    public void enqueue(Object obj) {
        if (nextIndex(last) == first) ensureCapacity();
        last = nextIndex(last);
        array[last] = (E) obj;
        size++;
    }

    @Override
    public E deque() {
        if (first == last) throw new EmptyStackException();
        first = nextIndex(first);
        size--;
        E temp = (E) array[first]; //for GC
        return temp;
    }

    @Override
    public int size() {
        return size;
    }
}
