package module2.t02;

import java.util.ArrayList;

/**
 * Created by alterG on 06.05.2017.
 */
public abstract class StationaryStuff {

    /**
     * @param employee man who has stationary stuff which we want to calculate summary
     * @return summary of stuff cost in rubles
     */
    public static int getSummaryCost(Employee employee) {
        if (employee == null) return 0;
        int summary = 0;
        ArrayList<StationaryStuff> stuff = employee.getStationaryStuffArrayList();
        for (int i = 0; i < stuff.size(); i++) {
            summary+=stuff.get(i).getCost();
        }
        return summary;
    }

    /** @return cost of stationary stuff in rubles*/
    abstract public int getCost();
    abstract public String getBrand();
}
