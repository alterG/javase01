package sandbox.Serialization.Example2;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                '}'+" "+getAdress(super.toString());
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // get adress from full adress (with package name)
    public static String getAdress(String adress) {
        Pattern pattern = Pattern.compile("@(.*)\\b");
        Matcher matcher =  pattern.matcher(adress);
        return matcher.find()?matcher.group(1):adress;

    }
}
