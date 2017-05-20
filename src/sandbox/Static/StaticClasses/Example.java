package sandbox.Static.StaticClasses;

/**
 * In inner static classes we can't access to non-static field of outer class
 * cause jvm doesn't create outer class when we create inner static class
 *
 * In inner non-static classes we cant declare static fields, cause we always
 * have object of outer class and we there is no reason to declare static fields in
 * inner class instead of outer class
 *
 * Created by alterG on 20.05.2017.
 */
public class Example {
    int nonStaticValue = 1;
    static int staticValue = 2;

    static class StaticClass {
        int a;
        static int c;

        void function() {
            int x = staticValue;
//          int y = nonStaticValue; compile error cause class is static
        }
    }

    class NonStaticClass {
        int a;
//        static int c; compile error inner classes can't have static declarations

        void function() {
            int x = staticValue;
            int y = nonStaticValue;
        }
    }
}
