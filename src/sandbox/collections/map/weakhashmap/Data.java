package sandbox.collections.map.weakhashmap;

/**
 * DTO object
 * Created by alterG on 22.06.2017.
 */
public class Data {
    public String name;
    public int value;

    @Override
    public String toString() {
        return String.format("name: %s\tvalue: %d", name, value);
    }

    public Data(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
