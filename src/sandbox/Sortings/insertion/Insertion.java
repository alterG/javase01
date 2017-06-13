package sandbox.Sortings.insertion;

import sandbox.Sortings.AbstractSortingAlgorithm;

import java.util.Arrays;

/**
 * Created by alterG on 13.06.2017.
 */
public class Insertion extends AbstractSortingAlgorithm {
    public static void main(String[] args) {
        Integer[] A = {5, 6, 3, 4, 1};
        Insertion ins = new Insertion();
        ins.sort(A);
        System.out.println(Arrays.toString(A));
    }

    @Override
    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i;
            while (j >= 1 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

    @Override
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            Comparable temp = a[i];
            int j = i;
            while (j >= 1 && less(temp, (a[j - 1]))) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }
}

