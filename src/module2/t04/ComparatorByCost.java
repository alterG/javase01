package module2.t04;

import module2.t02.StationaryStuff;

import java.util.Comparator;

/**
 * Created by alterG on 09.05.2017.
 */
public class ComparatorByCost implements Comparator<StationaryStuff>{

    @Override
    public int compare(StationaryStuff o1, StationaryStuff o2) {
        return o1.getCost() - o2.getCost();
    }
}
