package sandbox.myqueue;

import java.util.EmptyStackException;

/**
 * Created by alterG on 01.06.2017.
 */
public class QueueOnLinkedList<E> implements sandbox.myqueue.Queue {
    private Entry<E> last;
    private Entry<E> first;
    private int size;


    @Override
    public void enqueue(Object obj) {
        Entry<E> temp = new Entry<>((E) obj, null);
        if (first == null) {
            first = temp;
        } else {
            last.next = temp;
        }
        last = temp;
        size++;
    }

    @Override
    public E deque() {
        if (first == null) {
            throw new EmptyStackException();
        }
        Entry<E> temp = first;
        first = first.next;
        size--;
        return temp.value;
    }

    @Override
    public int size() {
        return size;
    }

    static class Entry<E> {
        private E value;

        public Entry(E value, Entry<E> next) {
            this.value = value;
            this.next = next;
        }

        private Entry<E> next;
    }
}
