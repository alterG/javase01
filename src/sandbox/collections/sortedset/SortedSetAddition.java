package sandbox.collections.sortedset;

/**
 * Created by alterG on 21.06.2017.
 */
interface SortedSetAddition<V extends Comparable> {

    V getNextElem(V elem);

    SortedSetAddition<V> getPrevElems(V elem);
}
