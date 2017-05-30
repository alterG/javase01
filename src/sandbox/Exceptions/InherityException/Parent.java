package sandbox.Exceptions.InherityException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Overridden method of subclass must throw only super class exception and their child
 * Another way we cant handle exceptions using dynamic linking
 * If method calls another method it must throw super class exceptions and their parents
 * Note: be care with constructors, which calls parent constructors
 * Created by alterG on 30.05.2017.
 */
public class Parent {
    int value;

    public Parent(int value) {
        this.value = value;
    }

    public Parent() throws IOException, ArithmeticException{
    }

    public void methodA() throws IOException {}
}

class Child extends Parent {

    public Child(int value) {
        super(value);
    }

    public Child() throws Exception{
    }

    @Override
    public void methodA() throws FileNotFoundException {}
}
