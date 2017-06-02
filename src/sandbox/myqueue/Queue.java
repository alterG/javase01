package sandbox.myqueue;

/**
 * Created by alterG on 01.06.2017.
 */
public interface Queue<E> {
    void enqueue(E obj);

    E deque();

    int size();
}
