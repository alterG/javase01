package sandbox.Static.OverridingOverloading;

/**
 * Created by alterG on 19.05.2017.
 */
public class Parent {
    static int getMax(int a, int b) {
        return a > b ? a : b;
    }

    // static method is overloading by non-static, it's ok
    int getMax(int a, int b, int c) {
        return getMax(a,b)>c?getMax(a,b):c;
    }
}


class Child extends Parent {
    // compile error cause static method cant be overridden by non-static
    /*int getMax(int a, int b) {
        System.out.println("Overriding Parent.getMax(int a, int b)");
        return a > b ? a : b;
    }*/

    // static method overrides static method it's ok
    static int getMax(int a, int b) {
        System.out.println("Overriding Parent.getMax(int a, int b)");
        return a > b ? a : b;
    }


}
