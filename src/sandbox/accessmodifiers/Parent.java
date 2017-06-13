package sandbox.accessmodifiers;

/**
 * Created by alterG on 20.05.2017.
 */
public class Parent {
    static int privateValue = 1;   //package-private access modifier
    static public int publicValue = 2;
    static protected int protectedValue = 3;

}


class InnerChild extends Parent {
    public void example() {
        int x = publicValue;
        int y = privateValue; // ok cause InnerChild in the same package as Parent
        int z = protectedValue; // access for childs
    }
}

class NotAChild {
    int x = Parent.publicValue;
    int y = Parent.privateValue; // ok cause InnerChild in the same package as Parent
    int z = Parent.protectedValue; // access for class in the same package
}


