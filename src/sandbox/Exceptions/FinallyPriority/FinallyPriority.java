package sandbox.Exceptions.FinallyPriority;

/**
 * finally will works anyway before leaving method
 * Created by alterG on 30.05.2017.
 */
public class FinallyPriority {
    static void procA() {
        try {
            System.out.println("In proc A");
            throw new RuntimeException("demo");
        } finally {
            System.out.println("Finally for procA");
        }
    }

    static void procB() {
        try {
            System.out.println("In proc B");
            return;
        } finally {
            System.out.println("Finally for procB");
        }
    }
    static void procC() {
        try {
            System.out.println("In proc C");
        } finally {
            System.out.println("Finally for C");
        }
    }

    public static void main(String[] args) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Exception has thrown");
        }
        procB();
        procC();
    }
}

        // Output:
        //In proc A
        //Finally for procA
        //Exception has thrown
        //In proc B
        //Finally for procB
        //In proc C
        //Finally for C
