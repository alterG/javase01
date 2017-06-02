package sandbox.hashmap;

/**
 * Created by alterG on 02.06.2017.
 */


public interface HashMap<K, V> {
    void put(K key, V value);
    V get(K key);   // return null if key doesn't present

    V getOrDefault(K key, V defaultvalue);

    int size();

    boolean remove(K key);
}
