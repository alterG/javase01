package sandbox.MyArrayList;

/**
 * Created by alterG on 30.05.2017.
 */
public interface MyList<E> {
    void add(E obj);
    E get (int index);
    void remove (int index);
    int size();
}
