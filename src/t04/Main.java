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
        System.out.println("Max sum is " + mirrorSumMax(a));

    }

    /**
     *
     * @param array
     * @return max of mirror sum a(0)+a(n), a(1)+a(n-1)...
     * if length isn't even number central sum equals central element
     */
    private static double mirrorSumMax (double[] array) {
        double sum;
        double max = - Double.MAX_VALUE;
        for (int i = 0; i < (array.length+1)/2; i++) {
            if (i != array.length/2) {
                sum = array[i]+array[array.length-i-1];
            }
            else {
                sum = array[i];
            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
}
