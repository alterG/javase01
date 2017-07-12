package sandbox.binaryheap;

/**
 * Created by alterG on 15.06.2017.
 */
public interface MaxPQ<V extends Comparable> {
    void insert(V value);

    V delMax();

    boolean isEmpty();

    V max();

    int size();

}
