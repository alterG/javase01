package sandbox.Java8Features;

/**
 * Annotation is just a guarantee, compiler doesn't allow to declare one more abstract method
 * Created by alterG on 19.05.2017.
 */
@FunctionalInterface
public interface ArraySummator {

//    abstract method
    long arraysSum(int[] ... A);

//    default method
    default long arraySum(int[] A) {
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
        }
        return sum;
    }
}
