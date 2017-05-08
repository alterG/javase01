package module2.t04;

import module2.t02.StationaryStuff;

import java.util.Comparator;

/**
 * Created by alterG on 09.05.2017.
 */
public class BiComparator implements Comparator<StationaryStuff> {

    private final Comparator<StationaryStuff> cmp1;
    private final Comparator<StationaryStuff> cmp2;

    public BiComparator(Comparator<StationaryStuff> cmp1, Comparator<StationaryStuff> cmp2) {
        this.cmp1 = cmp1;
        this.cmp2 = cmp2;
    }

    @Override
    public int compare(StationaryStuff o1, StationaryStuff o2) {
        int res = cmp1.compare(o1,o2);
        if (res == 0) {
            return cmp2.compare(o1, o2);
        }
        return res;
    }
}
