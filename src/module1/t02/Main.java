package module1.t02;

/**
 * Created by alterG on 23.04.2017.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @return minimum of sequence a(n)=1/(1+n^2) condition: a(n)<eps
*/
public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double eps;
        while (true) {
            try {
                System.out.println("Type epsilon for condition: a(n)<epsilon");
                eps = Double.parseDouble(reader.readLine());
                System.out.println("eps is " + eps);
                break;
            } catch (Exception e) {
                System.out.println("Please type a number.");
            }
        }
        int n = 0;
        double a = 1.0/(1+n*n);
        while (a > eps) {
            a = 1.0/(1+n*n);
            System.out.printf("a[%d] = %6f\n", n, a);
            n++;
        }
        System.out.println("The minimum index of element is " + --n);
    }
}
