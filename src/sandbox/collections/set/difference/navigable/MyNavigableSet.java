package sandbox.collections.set.difference.navigable;

import sandbox.collections.set.difference.parent.SortedSetAddition;

import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

/**
 * Created by alterG on 22.06.2017.
 */
public class MyNavigableSet<V extends Comparable> extends TreeSet<V> implements SortedSetAddition<V> {

    public MyNavigableSet(Collection<V> collection) {
        super(collection);
    }

    @Override
    public V getNextElem(V elem) {
        return super.contains(elem) ? super.higher(elem) : null;
    }

    @Override
    public SortedSetAddition<V> getPrevElems(V elem) {
        return super.contains(elem)
                ? (new MyNavigableSet<>(super.headSet(elem)))
                : (new MyNavigableSet<>(Collections.emptySet()));
    }
}
