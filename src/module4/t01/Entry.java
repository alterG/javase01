package module4.t01;

/**
 * Created by alterG on 29.05.2017.
 */
final public class Entry implements Comparable {
    private String key;
    private int value;

    public Entry(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Object o) {
        Entry entry2 =(Entry) o;
        return value-entry2.value;
    }

    @Override
    public String toString() {
        return String.format("%s = %d", key, value);
    }
}
