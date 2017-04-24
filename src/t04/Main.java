package t04;

import java.util.Scanner;

/**
 * Created by alterG on 23.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Type size of array: ");
        int length = in.nextInt();
        double a[] = new double[length];
        System.out.printf("Type %d elements: ", length);
        for (int i = 0; i < length; i++) {
            a[i]=in.nextDouble();
        }
        System.out.println("Max sum is " + pairSumMax(a));

    }

    /**
     *
     * @param array
     * @return max of mirror sum a(0)+a(1), a(2)+a(3)...
     * if length isn't even number central sum equals central element
     */
    private static double pairSumMax(double[] array) {
        double sum;
        double max = - Double.MAX_VALUE;
        for (int i = 0; i < array.length; i+=2) {
            if ( (i == array.length-1) && (array.length % 2 != 0) ) {
                sum = array[i];
            }
            else {
                sum = array[i]+array[i+1];
            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
}
