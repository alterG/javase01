package module2.t02;

import java.util.ArrayList;

/**
 * Created by alterG on 06.05.2017.
 */
public class Employee {
    private final String name;
    private ArrayList<StationaryStuff> stationaryStuffArrayList;

    public String getName() {
        return name;
    }

    public ArrayList<StationaryStuff> getStationaryStuffArrayList() {
        return stationaryStuffArrayList;
    }

    public Employee(String name) {
        this.name = name;
    }
    public void printStationaryStuff() {
        if (stationaryStuffArrayList == null) {
            System.out.println("Работник не имеет канцелярских принадлежностей.");
        }
        else {
            System.out.println(String.format("Работник %s имеет следующие канцелярские принадлежности:", name));
            for (int i = 0; i < stationaryStuffArrayList.size(); i++) {
                System.out.println(stationaryStuffArrayList.get(i));
            }
        }
    }

    public void addStationaryStuff (StationaryStuff ... array) {
        if (stationaryStuffArrayList == null) stationaryStuffArrayList= new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            stationaryStuffArrayList.add(array[i]);
        }
    }
}
