package sandbox.Sortings.BubbleSort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by alterG on 19.05.2017.
 */
public class BubbleSortTest {

    @Test
    public void sortTest() {
        int low = 0;
        int hight = 10000;
        int limits = 1000;
        int[] A = new Random().ints(limits, low, hight).toArray();
        int[] B = A.clone();
        BubbleSort.sort(A);
        Arrays.sort(B);
        assertArrayEquals(B, A);
    }

}