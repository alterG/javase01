package sandbox.accessmodifiers;

/**
 * Note: there example for static fields (and methods), for non-static fields/methods rules are the same
 * class: public, package-private (access to private fields only in the same package)
 * for inner class also exist static modifier {@link sandbox.Static.StaticClasses.Example}
 *
 * fields (also limited by class access modifier): public, protected (access for childs and classes in the same package),
 * package-private()
 * Created by alterG on 20.05.2017.
 */
public class Child extends Parent {

    public void example() {
        int x = publicValue;
//      int y = privateValue; compile error cause Parent is package-private class
        int z = protectedValue;  // access for child
    }
}
