package module2.t01;

import module2.t02.StationaryStuff;

/**
 * Created by alterG on 06.05.2017.
 */
public class Pen extends StationaryStuff {
    private final String brand;
    private float thickness;     //thickness in mm
    private String color;
    private int cost;           //cost in rubles

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {

        return brand;
    }

    public float getThickness() {
        return thickness;
    }

    public String getColor() {
        return color;
    }

    public Pen(String brand, int cost, float thickness, String color) {
        this.brand = brand;
        this.thickness = thickness;
        this.color = color;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Ручка \"%s\", толщина %.1fмм, цвет %s. Стоит %d руб.", brand, thickness, color, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (Float.compare(pen.thickness, thickness) != 0) return false;
        if (!brand.equals(pen.brand)) return false;
        return color.equals(pen.color);
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + (thickness != +0.0f ? Float.floatToIntBits(thickness) : 0);
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    protected int getCost() {
        return cost;
    }
}
