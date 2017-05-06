package module2.t02;

/**
 * Example of stationary stuff to represent getting summary of stationary stuff
 * Created by alterG on 06.05.2017.
 */
public class Notepad extends StationaryStuff {
    private int cost;

    public Notepad(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Блокнот за %d руб.", cost);
    }

    @Override
    protected int getCost() {
        return cost;
    }
}
