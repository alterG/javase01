package module2.t02;

/**
 * Example of stationary stuff to represent getting summary of stationary stuff
 * Created by alterG on 06.05.2017.
 */
public class Eraser extends StationaryStuff {
    private int cost;

    @Override
    public String toString() {
        return String.format("Стирательная резинка за %d руб.", cost);
    }

    public Eraser(int cost) {
        this.cost = cost;
    }

    @Override
    protected int getCost() {
        return cost;
    }
}
