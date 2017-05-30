package sandbox.MyStack.BasedOnArray;

/**
 * Created by alterG on 30.05.2017.
 */
public interface MyStackInterface<E> {
    void push (E obj);
    E pop();
    int size();
}
