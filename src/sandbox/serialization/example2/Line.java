package sandbox.serialization.example2;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                index, getAdress(super.toString()), point1, point2));
    }

    // get adress from full adress (with package name)
    public static String getAdress(String adress) {
        Pattern pattern = Pattern.compile("@(.*)\\b");
        Matcher matcher =  pattern.matcher(adress);
        return matcher.find()?matcher.group(1):adress;

    }
}
