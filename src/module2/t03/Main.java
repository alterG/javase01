package module2.t03;

import module2.t02.Employee;

/**
 * Created by alterG on 08.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Alexey");
        employee.addStationaryStuff(GloveService.getListStartingKit());
        employee.printStationaryStuff();
    }
}
