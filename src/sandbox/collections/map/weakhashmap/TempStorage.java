package sandbox.collections.map.weakhashmap;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Kind of cache
 * Created by alterG on 22.06.2017.
 */
public class TempStorage {

    public static void main(String[] args) {
        Map<Data, String> map = new WeakHashMap<>();
        Data data1 = new Data("data1", 50);
        Data data2 = new Data("data2", 100);
        map.put(data1, "one");
        map.put(data2, "two");
        System.out.println(map);
        data1 = null;       // gc free
        System.gc();
        System.out.println("--------- after data1 = null:");
        System.out.println(map);

    }
}
