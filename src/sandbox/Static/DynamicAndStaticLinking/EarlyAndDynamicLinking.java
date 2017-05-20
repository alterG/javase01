package sandbox.Static.DynamicAndStaticLinking;

/**
 * Example how dynamic and static linking works
 * private, static, final - static linking
 * other - dynamic linking (jvm calls method of object instead of reference)
 * Created by alterG on 19.05.2017.
 */
public class EarlyAndDynamicLinking {
    public static void main(String[] args) {
        EarlyAndDynamicLinking ptr = new Child();
        ptr.method1();
        ptr.method2();
        ptr.method3();
        ptr.method4();
        Child child = new Child();
//      child.method4();     access denied

        /*
        Output:
            method1_c
            method2
            method3
            method4
        */

    }

    // dynamic linking
    public void method1() {
        System.out.println("method1");
    }

    // static linking cause method cant be overridden
    final void method2() {
        System.out.println("method2");
    }

    // static linking, method is called by Class without reference to object
    static void method3() {
        System.out.println("method3");
    }

    private void method4() {
        System.out.println("method4");
    }
}

class Child extends EarlyAndDynamicLinking{

    // dynamic linking
    public void method1() {
        System.out.println("method1_c");
    }

    /* cant override final method
    public void method2() {
        System.out.println("method2_c");
    }
    */

    // static linking
    static void method3() {
        System.out.println("method3_c");
    }

    private void method4() {
        System.out.println("method4_c");
    }
}
