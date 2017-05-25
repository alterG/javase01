package sandbox.Serialization.Example2;

import java.io.Serializable;

/**
 * Created by alterG on 25.05.2017.
 */
public class Line implements Serializable {
    private Point point1;
    private Point point2;
    private int index;

    public Line() {
        System.out.println("Constructing empty line.");
    }

    public Line(Point point1, Point point2, int index) {
        this.point1 = point1;
        this.point2 = point2;
        this.index = index;
        System.out.println("Constructing line with index " + index);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void printInfo() {
        System.out.println(String.format("Line index = %d\nObject reference = %s\nFrom point 1 = %s\nTo point 2 = %s",
                index, super.toString(), point1, point2));
    }
}
