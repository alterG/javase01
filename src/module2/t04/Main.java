package module2.t04;

import module2.t02.Employee;
import module2.t02.StationaryStuff;
import module2.t03.GloveService;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by alterG on 09.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<StationaryStuff> stuff = GloveService.getListAdvancedKit();
        Employee employee = new Employee("Ostin");
        employee.addStationaryStuff(stuff);
        employee.printStationaryStuff();
        System.out.println("===========Sorted by cost:");
        stuff.sort(new ComparatorByCost());
        employee.printStationaryStuff();
        System.out.println("===========Sorted by brand:");
        stuff.sort(new ComparatorByBrand());
        employee.printStationaryStuff();
        System.out.println("===========Sorted by cost then brand:");
        stuff.sort(new BiComparator(new ComparatorByCost(), new ComparatorByBrand()));
        employee.printStationaryStuff();
    }
}
