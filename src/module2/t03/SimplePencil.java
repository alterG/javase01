package module2.t03;

import module2.t02.StationaryStuff;

/**
 * Created by alterG on 08.05.2017.
 */
public class SimplePencil extends StationaryStuff{
    private int cost;

    @Override
    public String toString() {
        return String.format("Простой карандаш за %d руб.\n", cost);
    }

    public SimplePencil(int cost) {
        this.cost = cost;
    }

    @Override
    protected int getCost() {
        return cost;
    }
}
