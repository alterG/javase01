package module2.t02;
import module2.t01.Pen;
/**
 * Created by alterG on 06.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("James");
        Pen pen1 = new Pen("Pilot", 40, 0.5f, "Синий");
        Notepad notepad1 = new Notepad(50);
        Eraser eraser1 = new Eraser(15);
        Notepad notepad2 = new Notepad(35);
        Pen pen2 = new Pen("Erich Krause", 120, 0.4f, "Черный");
        employee.addStationaryStuff(pen1, notepad1, eraser1, notepad2, pen2);
        employee.printStationaryStuff();
        String result = String.format("Общая стоимость канцелярских принадлежностей %s равна %d.", employee.getName(), StationaryStuff.getSummaryCost(employee));
        System.out.println(result);
    }
}
