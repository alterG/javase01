package sandbox.collections.set.difference.parent;

/**
 * Created by alterG on 21.06.2017.
 */
public interface SortedSetAddition<V extends Comparable> {

    V getNextElem(V elem);

    SortedSetAddition<V> getPrevElems(V elem);
}
