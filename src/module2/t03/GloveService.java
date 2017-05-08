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
}
