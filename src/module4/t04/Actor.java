package module4.t04;

import java.io.Serializable;

/**
 * Created by alterG on 29.05.2017.
 */
public class Actor implements Serializable {
    private String name;

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public Actor(String name) {

        this.name = name;
    }
}
