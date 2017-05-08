package module2.t02;

/**
 * Example of stationary stuff to represent getting summary of stationary stuff
 * Created by alterG on 06.05.2017.
 */
public class Eraser extends StationaryStuff {
    private int cost;
    private String brand;

    @Override
    public String getBrand() {
        return brand;
    }

    public Eraser(int cost, String brand) {
        this.cost = cost;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return String.format("Стирательная \"%s\" резинка за %d руб.",brand, cost);
    }

    public Eraser(int cost) {
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
