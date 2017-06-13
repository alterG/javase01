package sandbox.binarysearch;

/**
 * Created by alterG on 30.05.2017.
 */
// ToDo: how does it work?
public class BinarySearch {

    public static int search(int[] a, int b) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid  = (left+right)/2;
            if (a[mid] == b) return mid;
            else if (b < a[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
}
