package sandbox.Exceptions.HiddenException;

/**
 * X-zibit exception
 * Created by alterG on 30.05.2017.
 */
public class Main {
    public static double salary(int coeff) throws HiddenException {
        double d;
        try {
            if ((d = 10 - 100 / coeff) < 0) {
                throw new HiddenException("Negative salary");
            }
            else return d;
        } catch (ArithmeticException e) {
            throw new HiddenException("div by zero", e);
        }
    }

    public static void main(String[] args) {
        try {
            double res = salary(3);
        } catch (HiddenException e) {
            System.err.println(e.toString());
            System.err.println(e.getHidden());
        }
    }
}
