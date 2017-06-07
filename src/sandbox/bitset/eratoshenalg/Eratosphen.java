package sandbox.bitset.eratoshenalg;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import static java.lang.Math.sqrt;

/**
 * Created by alterG on 01.06.2017.
 */
public class Eratosphen {
    public static void main(String[] args) {
        solution(1_000_000);
    }

    public static void solution(int max) {
        BitSet numbers = new BitSet(max);
        numbers.set(1, max, true);
        for (int i = 2; i < sqrt(max); i = numbers.nextSetBit(i + 1)) {
            if (i < 0) break;
            for (int j = i + i; j <= max; j += i) {
                numbers.clear(j);
            }

        }

        List<Integer> res = new ArrayList<>(numbers.cardinality());
        for (int i = 1; i < max; i = numbers.nextSetBit(i + 1)) {
            if (i < 0) break;
            if (numbers.get(i)) {
//                res.add(i);
                System.out.println(i);
            }

        }

    }
}
