package sandbox.collections.map.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by alterG on 22.06.2017.
 */
public class SimpleLRUCache<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public SimpleLRUCache(int initialCapacity) {
        super(initialCapacity + 1, 1.1f, true);
        this.capacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    // Demonstration ('-' means oldest access element)
    public static void main(String[] args) {
        SimpleLRUCache<Integer, String> cache = new SimpleLRUCache(2);
        cache.put(1, "one");
        cache.put(2, "two"); //1-, 2
        cache.get(1); //1, 2-
        cache.put(3, "three"); // 1-, 3
        System.out.println(cache);
    }
}
