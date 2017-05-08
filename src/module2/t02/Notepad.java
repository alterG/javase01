package module2.t02;

/**
 * Example of stationary stuff to represent getting summary of stationary stuff
 * Created by alterG on 06.05.2017.
 */
public class Notepad extends StationaryStuff {
    private int cost;
    private String brand;

    public Notepad(int cost, String brand) {
        this.cost = cost;
        this.brand = brand;
    }

    public Notepad(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Блокнот \"%s\" за %d руб.", brand, cost);
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getBrand() {
        return brand;
    }
}
