package sandbox.Exceptions.DoubleReturn;

/**
 * Finally block will overhead return in try block
 * Created by alterG on 30.05.2017.
 */
public class DoubleReturn {
    private final static int age = 30;

    private static int getAge() {
        try {
            return age-3;
        } finally {
            return age;
        }
    }

    public static final void main(String[] args) {
        System.out.println(getAge());   // return 30
    }
}
