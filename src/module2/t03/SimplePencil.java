package module2.t03;

import module2.t02.StationaryStuff;

/**
 * Created by alterG on 08.05.2017.
 */
public class SimplePencil extends StationaryStuff{
    private int cost;
    private String brand;

    @Override
    public String getBrand() {
        return brand;
    }

    public SimplePencil(int cost, String brand) {
        this.cost = cost;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return String.format("Простой карандаш \"%s\" за %d руб.", brand, cost);
    }

    public SimplePencil(int cost) {
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
