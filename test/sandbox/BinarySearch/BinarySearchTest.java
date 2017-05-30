package sandbox.BinarySearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by alterG on 30.05.2017.
 */
public class BinarySearchTest {
    int[] a;

    @Test
    public void searchTest() {
        a = new int[]{1,3,5,7,8,11,14,15,17,18};
        int result = BinarySearch.search(a, 7);
        assertEquals(3, result);
    }

    @Test
    public void searchTestNoElem() {
        a = new int[]{1,2,3,4,5,6};
        int result = BinarySearch.search(a, 1);
        assertEquals(0, result);
    }

    @Test
    public void randomSearchTest() {
        final int testCount = 100;
        for (int i = 0; i < testCount; i++) {
            Random random = new Random();
            int size = random.nextInt(1000);
            a = new int[size];
            for (int j = 0; j < size; j++) {
                a[j] = random.nextInt(100_000);
            }
            Arrays.sort(a);
            int searchKey = random.nextInt(100_000);
            int rightAnswer = Arrays.binarySearch(a, searchKey);
            if (rightAnswer < 0) rightAnswer = -1;
            int testMethodAnswer = BinarySearch.search(a, searchKey);
            assertEquals(rightAnswer, testMethodAnswer);
        }
    }

}