package sandbox.hashmap;

/**
 * Created by alterG on 02.06.2017.
 */
// ToDo: add remove() and ensureCapacity()
public class MyHashMap<K,V> implements sandbox.hashmap.HashMap<K,V> {
    private Entry[] array;
    private final int INITIAL_SIZE = 5;
    private final int LENGTH_MULTIPLICATOR = 2;
    int size;
    double loadFactor = 0.75f;
    int loadCellscount;

    public MyHashMap() {
        array = new Entry[INITIAL_SIZE];
    }

    private void ensureCapacity() {
        Entry[] oldArray = array;
        int oldSize = size;
        array = new Entry[oldArray.length * LENGTH_MULTIPLICATOR];
        for (int i = 0; i < oldArray.length; i++) {
            Entry<K, V> currentEntry = oldArray[i];
            while (currentEntry != null) {
                put(currentEntry.key, currentEntry.value);
                currentEntry = currentEntry.next;
            }
        }
        size = oldSize;
    }

    private int getIndex(K key) {
        if (key == null) throw new NullPointerException("Key is null.");
        int hash = key.hashCode();
        int index = Math.abs(hash % array.length);
        return index;
    }

    @Override
    public void put(K key, V value) {
        if (loadCellscount >= array.length * loadFactor) {
            ensureCapacity();
        }
        size++;
        int index = getIndex(key);
        if (array[index] == null) {
            array[index] = new Entry(key, value);
            loadCellscount++;
        } else {
            Entry cur = array[index];
            while (cur.next != null) {
                if (cur.key.hashCode() == key.hashCode() &&
                        cur.key == key && cur.key.equals(key)) {
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
        if (cur.key.equals(key)) {           // first elem has same key
            array[index] = cur.next;
            return true;
        }
        Entry prev = cur;               // target elem has previous elem
        while (cur.next != null) {
            cur = cur.next;
            if (cur.key.equals(key)) {
                prev.next = cur.next;
                return true;
            }
        }
        return false;
    }

    class Entry<K,V> {
        private V value;
        private K key;
        private int hash;
        private Entry next;

        public Entry(K key, V value) {
            this.value = value;
            this.key = key;
        }

    }
}
