package sandbox.Static.StaticClasses;

/**
 * Created by alterG on 20.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        Example.StaticClass staticClass = new Example.StaticClass();

//      Can't create inner class (cause we need outer class)
//      Example.NonStaticClass nonStaticClass = new Example.NonStaticClass();
    }
}
