package sandbox.collections.set.nulldeleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by alterG on 15.06.2017.
 */
public class NullDeleter {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(null);
        list.add(3);
        list.add(null);
        for (Integer x : list) {    //cant use int x cause unboxing from null calls NullPointerException
            System.out.println(x);
        }
        System.out.println("After delete");
        list.removeAll(Collections.singleton(null));
        for (int x : list) {        // now we we have no null pointers so we can use unboxing (but there is stupid move)
            System.out.println(x);
        }
    }
}
