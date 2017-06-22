package sandbox.collections.sortedset;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Example:
 * write Integer getNextElem(Integer elem), SortedSet<Integer> getPrevElems(Integer elem)
 * Created by alterG on 21.06.2017.
 */
public class MySortedSet<V extends Comparable> extends TreeSet<V> implements SortedSetAddition<V> {

    public MySortedSet(Collection<V> collection) {
        super(collection);
    }

    @Override
    public V getNextElem(V elem) {
        Iterator<V> iterator = super.iterator();
        while (iterator.hasNext()) {
            V cur = iterator.next();
            if (elem.equals(cur)) {
                break;
            }
        }

        return iterator.hasNext() ? iterator.next() : null;
    }

    @Override
    public SortedSetAddition<V> getPrevElems(V elem) {
        Iterator<V> iterator = super.iterator();
        MySortedSet<V> resultSet = new MySortedSet<>(Collections.emptySet());
        boolean elemIsExist = false;
        while (iterator.hasNext()) {
            V cur = iterator.next();
            if (cur.equals(elem)) {
                elemIsExist = true;
                break;
            }
            resultSet.add(cur);
        }
        return elemIsExist
                ? resultSet
                : new MySortedSet<>(Collections.emptySet());
    }

}
