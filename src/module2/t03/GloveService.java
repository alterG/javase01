package module2.t03;

import module2.t01.*;
import module2.t02.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alterG on 08.05.2017.
 */
public class GloveService {

    static public ArrayList<StationaryStuff> getListStartingKit() {
        Pen pen = new Pen("Epam Inc", 70, 0.7f, "Blue");
        Eraser simpleEraser = new Eraser(15);
        InkEraser inkEraser = new InkEraser(25);
        Notepad notepad = new Notepad(60);
        SimplePencil simplePencil = new SimplePencil(10);
        ArrayList<StationaryStuff> startingKitList = new ArrayList<>();
        startingKitList.add(pen);
        startingKitList.add(simpleEraser);
        startingKitList.add(inkEraser);
        startingKitList.add(notepad);
        startingKitList.add(simplePencil);
        return startingKitList;
    }

    static public ArrayList<StationaryStuff> getListAdvancedKit() {
        ArrayList<StationaryStuff> advancedKitList = new ArrayList<>();
        advancedKitList.add(new Pen("Epam Inc", 70, 0.7f, "Blue"));
        advancedKitList.add(new Pen("Erich Krause", 70, 0.7f, "Blue"));
        advancedKitList.add(new Pen("Pilot", 70, 0.7f, "Blue"));
        advancedKitList.add(new Pen("Epam Inc", 60, 0.7f, "Blue"));
        advancedKitList.add(new Pen("Epam Inc", 50, 0.7f, "Blue"));
        advancedKitList.add(new Eraser(25, "Power-A"));
        advancedKitList.add(new Notepad(40, "PirateBay"));
        advancedKitList.add(new SimplePencil(10, "RDBC"));
        return advancedKitList;
    }
}
