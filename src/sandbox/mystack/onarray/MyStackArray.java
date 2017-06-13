package sandbox.mystack.onarray;

import java.util.EmptyStackException;

/**
 * Created by alterG on 30.05.2017.
 */
public class MyStackArray<E> implements MyStackInterface<E> {
    final static int BASE_CAPACITY = 10;
    Object[] objects;
    int size;

    public MyStackArray() {
        objects = new Object[BASE_CAPACITY];
    }

    public void ensureCapacity() {
        Object[] newArr = new Object[(int) (objects.length * 1.5)];
        System.arraycopy(objects, 0, newArr, 0, objects.length);
        objects = newArr;
    }

    @Override
    public void push(E obj) {
        if (size >= objects.length) {
            ensureCapacity();
        }
        objects[size++] = (E) obj;
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E e = (E) objects[--size];
        objects[size] = null;
        return e;
    }

    @Override
    public int size() {
        return size;
    }
}
