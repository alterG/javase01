package sandbox.Java8Features;

/**
 * Example of java 1.8 features, such as lambda, functional interfaces and static (and non-static) references
 * IMPORTANT: references can indicate on methods and constructors (!)
 * There is full article https://habrahabr.ru/post/216431/
 * Created by alterG on 19.05.2017.
 */

// The solution to implement Interface №1 (implementation by class)
class ArraySummatorClass implements ArraySummator {
    @Override
    public long arraysSum(int[]... A) {
        long sum = 0;
        for (int[] ints : A) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }
}


public class Java8Features {
    public static void main(String[] args) {

        ArraySummatorClass classArraySummator = new ArraySummatorClass();
        int[] A = {1, 2, 3};
        int[] B = {4, 5, 6};
        int[] C = {7, 8, 9};

        // overrided method of interface
        System.out.println("(A+B+C) Implementation by class: " + classArraySummator.arraysSum(A, B, C));
        // default method of interface
        System.out.println("(A) Default method: " + classArraySummator.arraySum(A));

        // The solution to implement Interface №2 (anonymous class)
        ArraySummator anonArraySummator = new ArraySummator() {
            @Override
            public long arraysSum(int[]... A) {
                long sum = 0;
                for (int[] ints : A) {
                    for (int anInt : ints) {
                        sum += anInt;
                    }
                }
                return sum;
            }
        };
        System.out.println("(A+B+C) Anonymous class: " + anonArraySummator.arraysSum(A, B, C));

        // The solution to implement Interface №3 (lambda expressions)
        ArraySummator lambdaSumator = (arrays) -> {
            long sum = 0;
            for (int[] ints : arrays) {
                for (int anInt : ints) {
                    sum += anInt;
                }
            }
            return sum;
        };
        System.out.println("(A+B+C) Lambda expressions: " + lambdaSumator.arraysSum(A, B, C));

        // The solution to implement Interface №4 (functional interface and lambda expressions)
        ArraySummator functionalInterface;
        functionalInterface = (arrays) -> {
            long sum = 0;
            for (int[] ints : arrays) {
                for (int anInt : ints) {
                    sum += anInt;
                }
            }
            return sum;
        };
        System.out.println("(A+B+C) Functional interface: "+functionalInterface.arraysSum(A, B, C));

        // The solution to implement Interface №5 (Also static references to methods)
        ArraySummator functionalInterface1 = Java8Features::getArraysSumm;
        System.out.println("(A+B+C) Also static refs: " + functionalInterface1.arraysSum(A, B, C));

        // The solution to implement Interface №6 (Also non-static references to methods)
        Java8Features featureDemonstraton = new Java8Features();
        ArraySummator functionalInterface2 = featureDemonstraton::getArraySumm2;
        System.out.println("(A+B+C) And non-static refs: " + functionalInterface2.arraysSum(A, B, C));
    }

    private static long getArraysSumm(int[] ... arrays) {
        long sum = 0;
        for (int[] ints : arrays) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }

    private long getArraySumm2(int[] ... arrays) {
        long sum = 0;
        for (int[] ints : arrays) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }
}



