package module2.t05;

/**
 * Created by alterG on 15.05.2017.
 */
public class Mark<T extends Number> implements Comparable{
    private T value;

    public Mark(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        return (int) (this.value.doubleValue() - ((Mark) o).value.doubleValue());
    }
}
