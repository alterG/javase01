package sandbox.sortings.insertion;

import sandbox.sortings.template.AbstractSortingAlgorithm;

import java.util.Arrays;

/**
 * Time complexity:
 * random - O(n^2)
 * bad - O(n^2)
 * best - O(n)
 *
 * Memory complexity:
 * always O(1)
 *
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
            while (j > 0 && temp < a[j - 1]) {
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
            while (j > 0 && less(temp, (a[j - 1]))) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }
}

