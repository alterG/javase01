package sandbox.binaryheap;

/**
 * Created by alterG on 15.06.2017.
 */
public class myMaxPQ<V extends Comparable> implements MaxPQ<V> {
    public static void main(String[] args) {
        myMaxPQ<Integer> pq = new myMaxPQ<>();
        pq.insert(3);
        pq.insert(6);
        pq.insert(4);
        pq.insert(7);
        pq.insert(9);
        pq.delMax();
        pq.printPQ();
    }

    private Object[] array;
    private int nextElemIndex;

    public myMaxPQ() {
        array = new Object[16];
        nextElemIndex = 1;
    }

    @Override
    public void insert(V value) {
        array[nextElemIndex++] = value;
        swim(nextElemIndex - 1);
    }

    private void swim(int index) {
        while (index > 1 && !less(index, index / 2)) {
            swap(array, index, index / 2);
            index = index / 2;
        }
    }

    private void sink(int index) {
        while (2 * index < nextElemIndex) {
            if (less(index, 2 * index)) {
                swap(array, index, 2 * index);
                index = 2 * index;
                continue;
            }
            if (less(index, 2 * index + 1)) {
                swap(array, index, 2 * index + 1);
                index = 2 * index + 1;
                continue;
            }
            break;
        }
    }

    private boolean less(int x, int y) {
        return ((V) array[x]).compareTo(((V) array[x])) < 0;
    }

    @Override
    public V delMax() {
        V result = (V) array[1];
        array[1] = array[--nextElemIndex];
        sink(1);
        return null;
    }

    private static void swap(Object[] array, int x1, int x2) {
        Object temp = array[x1];
        array[x1] = array[x2];
        array[x2] = temp;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public V max() {
        return (V) array[1];
    }

    @Override
    public int size() {
        return 0;
    }

    private static int getParentIndex(int elementIndex) {
        return elementIndex / 2;
    }

    private static int getLeftChildIndex(int elementIndex) {
        return 2 * elementIndex;
    }

    private static int getRightChildIndex(int elementIndex) {
        return 2 * elementIndex + 1;
    }

    public void printPQ() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("elem" + i + " = " + (V) array[i]);
        }
    }
}
