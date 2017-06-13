package sandbox.sortings.shell;

import sandbox.sortings.template.AbstractSortingAlgorithm;

import java.util.Arrays;

/**
 * Created by alterG on 13.06.2017.
 */
public class Shell extends AbstractSortingAlgorithm {
    public static void main(String[] args) {
        Integer[] A = {5, 6, 3, 4, 1};
        Shell shl = new Shell();
        shl.sort(A);
        System.out.println(Arrays.toString(A));
    }

    @Override
    public void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; (j >= h) && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    @Override
    public void sort(int[] a) {
        int length = a.length;
        int h = 1;
        while (h < length / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                int j = i;
                int temp = a[i];
                for (; (j >= h) && (temp < a[j - h]); j -= h) {
                    a[j] = a[j - h];
                }
                a[j] = temp;
            }
            h /= 3;
        }
    }
}
