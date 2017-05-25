package sandbox.Serialization.Example2;

import java.io.Serializable;

/**
 * Created by alterG on 25.05.2017.
 */
public class Point implements Serializable {
    private double x;
    private double y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
