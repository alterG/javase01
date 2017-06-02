package sandbox.hashmap;

/**
 * Created by alterG on 02.06.2017.
 */
public class MyHashMap<K,V> implements sandbox.hashmap.HashMap<K,V> {
    private Entry[] array;
    private final int INITIAL_SIZE = 10;
    int size;

    public MyHashMap() {
        array = new Entry[INITIAL_SIZE];
    }

//    private void ensureCapacity() {
//    }

    private int getIndex(K key) {
        if (key == null) throw new NullPointerException("Key is null.");
        int hash = key.hashCode();
        int index = hash%array.length;
        return index;
    }

    @Override
    public void put(K key, V value) {
        size++;
        int index = getIndex(key);
        if (array[index] == null) {
            array[index] = new Entry(key, value);
        } else {
            Entry cur = array[index];
            while (cur.next != null) {
                if (cur.key == key) {
                    cur.key = value;
                    return;
                }
                cur = cur.next;
            }
            cur.next = new Entry(key, value);
        }
        return;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        Entry cur = array[index];
        while (cur != null) {
            if (cur.key == key) break;
            cur = cur.next;
        }
        if (cur == null) return null;
        return (V) cur.value;
    }

    @Override
    public V getOrDefault(K key, V defaultvalue) {
        V result = get(key);
        return (result!=null)?result:defaultvalue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(K key) {
        int index = getIndex(key);
        Entry cur = array[index];
        if (cur == null) return false;  // array is empty
        if (cur.key == key) {           // first elem has same key
            array[index] = cur.next;
            return true;
        }

        Entry prev = cur;               // target elem has previous elem
        while (cur.next != null) {
            cur = cur.next;
            if (cur.key == key) {

            }
        }
        return false;
    }

    class Entry<K,V> {
        private V value;
        private K key;
        private Entry next;

        public Entry(K key, V value) {
            this.value = value;
            this.key = key;
        }

    }
}
